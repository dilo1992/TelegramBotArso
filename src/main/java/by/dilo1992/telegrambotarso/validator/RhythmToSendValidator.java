package by.dilo1992.telegrambotarso.validator;

import by.dilo1992.telegrambotarso.annotation.SelectRhythmToSendAd;
import by.dilo1992.telegrambotarso.annotation.SelectTypeOfProducts;
import by.dilo1992.telegrambotarso.model.RhythmToSendAd;
import by.dilo1992.telegrambotarso.model.TypesOfProduct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RhythmToSendValidator implements ConstraintValidator<SelectRhythmToSendAd, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean exist = true;
        try {
            RhythmToSendAd.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            exist = false;
        }
        return exist;
    }
}
