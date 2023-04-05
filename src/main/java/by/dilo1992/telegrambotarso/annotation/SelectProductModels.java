package by.dilo1992.telegrambotarso.annotation;

import by.dilo1992.telegrambotarso.validator.ProductModelValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ProductModelValidator.class})
public @interface SelectProductModels {

    String message() default "Product model must match the nomenclature";

    //these two fields are mandatory, where they are used we don't need to know yet, just add them and that's it
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
