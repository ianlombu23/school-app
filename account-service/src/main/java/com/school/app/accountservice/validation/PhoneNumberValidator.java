package com.school.app.accountservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid, String> {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?\\d{10,15}$");

    @Override
    public void initialize(PhoneNumberValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null && PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }
}
