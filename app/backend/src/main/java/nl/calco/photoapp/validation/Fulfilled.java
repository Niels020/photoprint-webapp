package nl.calco.photoapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FulfilledValidator.class)

public @interface Fulfilled {

    String message() default "fulfilled is not valid. Options are true, false, cancelled or error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}