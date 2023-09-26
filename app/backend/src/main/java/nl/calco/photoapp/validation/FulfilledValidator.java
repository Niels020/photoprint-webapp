package nl.calco.photoapp.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FulfilledValidator implements ConstraintValidator<Fulfilled, String> {

    List<String> valid = Arrays.asList("true", "false", "error", "cancelled");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        for (String string : valid) {
            if (value.equals(string)) return true;
        }
        return false;
    }

}