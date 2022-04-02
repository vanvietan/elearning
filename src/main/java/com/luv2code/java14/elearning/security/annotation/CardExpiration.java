package com.luv2code.java14.elearning.security.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = CardExpirationValidator.class)
public @interface CardExpiration {
    String message() default "Expiration invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
