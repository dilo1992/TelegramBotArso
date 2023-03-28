package by.dilo1992.telegrambotarso.annotation;

import by.dilo1992.telegrambotarso.validator.ProductModelValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ProductModelValidator.class})
public @interface SelectProductModelFromEnum {

    String message() default "Product model must match the nomenclature";

    //эти два поля обязательные, где они применяются нам знать пока не обязательно, просто добавляем и все
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
