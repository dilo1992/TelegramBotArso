package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.entity.Product;
import by.dilo1992.telegrambotarso.model.TypeOfProductEnum;
import by.dilo1992.telegrambotarso.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReplyKeyboards {

    @Autowired
    private final ProductRepository productRepository;

    protected ReplyKeyboardMarkup getReplyKeyboardCategoryOfProduct() {
        //создаем разметку для клавиш переписки
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        //создаем лист рядов
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        for (TypeOfProductEnum typeOfProduct : TypeOfProductEnum.values()) {
            //создаем новый макет ряда
            KeyboardRow row = new KeyboardRow();
            //заполняем ряд клавишей (одной)
            row.add(typeOfProduct.name());
            //добавляем ряд с кнопкой в ряды ответов
            keyboardRows.add(row);
        }

        //добавляем в разметку ряды с кнопками
        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    protected ReplyKeyboardMarkup getReplyKeyboardForTypeOfProduct(String typeOfProduct) throws IllegalArgumentException {
        //создаем разметку для клавиш переписки
        try {
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<Product> modelsOfProduct = productRepository.findAllByTypeOfProduct(typeOfProduct);
            //создаем лист рядов
            List<KeyboardRow> keyboardRows = new ArrayList<>();

            for (Product product : modelsOfProduct) {
                //создаем новый макет ряда
                KeyboardRow row = new KeyboardRow();
                //заполняем ряд клавишей (одной)
                row.add(product.getModelOfTypeOfProduct());
                //добавляем ряд с кнопкой в ряды ответов
                keyboardRows.add(row);
            }

            //добавляем в разметку ряды с кнопками
            keyboardMarkup.setKeyboard(keyboardRows);
            return keyboardMarkup;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Exception in getReplyKeyboardForTypeOfProduct method: " + e.getMessage());
        }
    }
}