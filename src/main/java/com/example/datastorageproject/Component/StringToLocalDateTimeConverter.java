package com.example.datastorageproject.Component;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm";

    @Override
    public LocalDateTime convert(String source) {
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
}