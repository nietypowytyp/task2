package com.example.thymeleaf.util;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class LogMaskingUtil {

    // Pattern for masking the address
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("(?i)(street='.*?',|zipCode='.*?',|city='.*?',|state='.*?',)");
    
    // Replace birthdate with masked format
    public static String maskBirthday(LocalDate birthday) {
        if (birthday == null) return "****-**-**";
        return "****-**-**";
    }

    // Generic method to mask any field with '***'
    public static String maskField(String value) {
        if (value == null || value.isEmpty()) return value;
        return "***";
    }
}

