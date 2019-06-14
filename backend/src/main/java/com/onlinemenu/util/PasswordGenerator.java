package com.onlinemenu.util;

import org.apache.commons.lang.RandomStringUtils;

public class PasswordGenerator {

    private static final Integer PASSWORD_LENGTH = 8;

    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(PASSWORD_LENGTH);
    }
}
