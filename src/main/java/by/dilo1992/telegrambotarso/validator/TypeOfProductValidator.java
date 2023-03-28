package by.dilo1992.telegrambotarso.validator;

import by.dilo1992.telegrambotarso.annotation.SelectTypeOfProductFromEnum;
import by.dilo1992.telegrambotarso.model.TypeOfProductEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TypeOfProductValidator implements ConstraintValidator<SelectTypeOfProductFromEnum, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean exist = true;
        try {
            TypeOfProductEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            exist = false;
        }
        return exist;
    }
}
