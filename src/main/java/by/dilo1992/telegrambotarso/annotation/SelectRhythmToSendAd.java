package by.dilo1992.telegrambotarso.annotation;

import by.dilo1992.telegrambotarso.validator.RhythmToSendValidator;
import by.dilo1992.telegrambotarso.validator.TypeOfProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RhythmToSendValidator.class})
public @interface SelectRhythmToSendAd {

    String message() default "This field should be contains in the rhythm to send ads enum";

    //these two fields are mandatory, where they are used we don't need to know yet, just add them and that's it
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
