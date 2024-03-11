package com.example.eldar.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tools {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static LocalDateTime stringToLocalDateTime(String date) {
        return LocalDateTime.parse(date, formatter);
    }
}
