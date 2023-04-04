package by.dilo1992.telegrambotarso.annotation;

import by.dilo1992.telegrambotarso.validator.TypeOfProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TypeOfProductValidator.class})
public @interface SelectTypeOfProducts {

    String message() default "This field should be contains in the type of product enum";

    //these two fields are mandatory, where they are used we don't need to know yet, just add them and that's it
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
