package nl.calco.photoapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DayOfWeekValidator.class)

public @interface DayOfWeek {

    String message() default "dayOfWeek is not valid. Options are monday, tuesday, wednesday, thursday, friday, saturday or sunday";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};   
}
