package com.example.thymeleaf.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import com.example.thymeleaf.util.LogMaskingUtil;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@Entity
@Table(name = "address")
@EqualsAndHashCode(of = {"id"})
public class Address {
    @Transient
    private static final Logger logger = LoggerFactory.getLogger(Address.class);

    @Id
    private String id;

    @Column(name = "zip_code")
    private String zipCode;

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "fk_student")
    private Student student;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", zipCode='" + LogMaskingUtil.maskField(zipCode) + '\'' +
                ", street='" + LogMaskingUtil.maskField(street) + '\'' +
                ", number='" + LogMaskingUtil.maskField(number) + '\'' +
                ", complement='" + LogMaskingUtil.maskField(complement) + '\'' +
                ", district='" + LogMaskingUtil.maskField(district) + '\'' +
                ", city='" + LogMaskingUtil.maskField(city) + '\'' +
                ", state='" + LogMaskingUtil.maskField(state) + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
