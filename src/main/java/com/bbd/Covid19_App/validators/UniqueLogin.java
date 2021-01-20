package com.bbd.Covid19_App.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= UniqueLoginChecker.class)
public @interface UniqueLogin {

    String message() default "Login is NOT unique.";
    Class<?>[]  groups() default{};
    Class<? extends Payload>[] payload() default{};


}
