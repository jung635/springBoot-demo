package com.example.demo.todo.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TokenGenerator {
    public static String generateRandomChar(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateRandomCharWithPrefix(String prefix, int length) {
        return prefix + generateRandomChar(length - prefix.length());
    }
}
