package com.techabraao.books.demo.validators;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
    public Boolean passwordsMatches(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
