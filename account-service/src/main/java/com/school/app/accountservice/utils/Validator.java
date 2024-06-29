package com.school.app.accountservice.utils;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public boolean isValidEmail(String email) {
        String regex = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        return email.matches(regex);
    }
}
