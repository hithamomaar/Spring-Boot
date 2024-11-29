package com.hitham.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String Prefix;

    @Override
    public void initialize(CourseCode coCode) {
        Prefix = coCode.value();
    }

    @Override
    public boolean isValid(String Code, ConstraintValidatorContext constraintValidatorContext) {
        if (Code == null) {
            return false;
        }
        return Code.startsWith(Prefix);
    }
}
