package by.dilo1992.telegrambotarso.validator;

import by.dilo1992.telegrambotarso.annotation.SelectProductModels;
import by.dilo1992.telegrambotarso.model.CementModels;
import by.dilo1992.telegrambotarso.model.CfbBlockModels;
import by.dilo1992.telegrambotarso.model.ConcreteModels;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductModelValidator implements ConstraintValidator<SelectProductModels, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean exist = true;

        //if the value is not contained in the corresponding enum, then it will be
        // an IllegalArgumentException exception is thrown and these variables will be equal to 1 each
        //then we check if they are all equal to 1, then the value is invalid,
        // if at least one is not equal to 1, then it is valid
        int resultCfbBlock = 0;
        int resultCement = 0;
        int resultConcrete = 0;

        try {
            CfbBlockModels.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            resultCfbBlock = 1;
        }

        try {
            ConcreteModels.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            resultConcrete = 1;
        }

        try {
            CementModels.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            resultCement = 1;
        }

        if (resultCfbBlock == 1 && resultConcrete == 1 && resultCement == 1) {
            exist = false;
        } else {
            exist = true;
        }

        return exist;
    }
}
