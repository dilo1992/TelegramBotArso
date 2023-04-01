package by.dilo1992.telegrambotarso.validator;

import by.dilo1992.telegrambotarso.annotation.SelectProductModelFromEnum;
import by.dilo1992.telegrambotarso.model.CementModels;
import by.dilo1992.telegrambotarso.model.CfbBlockModels;
import by.dilo1992.telegrambotarso.model.ConcreteModels;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductModelValidator implements ConstraintValidator<SelectProductModelFromEnum, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean exist = true;

        //если не содержится значение в соответствующих enum, то будет
        // выброшено исключение IllegalArgumentException и эти переменные станут равными 1 каждая
        //потом проверяем, если они все равны 1, то значение невалидно,
        // если хоть одна не равна 1 - то валидно
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
