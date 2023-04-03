package by.dilo1992.telegrambotarso;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String randomPassword = "";
        List<String> charsForPassword = new ArrayList<>();
        //добавляем в массив символов буквы
        for (char c = 'A'; c <= 'z'; c++) {
            String s = "";
            s += c;
            charsForPassword.add(s);
            if (c == 'Z') {
                c = 'a' - 1;
            }
        }
        //добавляем в массив символов цифры
        for (int i = 0; i < 10; i++) {
            String s = "";
            s += i;
            charsForPassword.add(s);
        }

        //добавляем в строку пароля рандомные символы из массива символов
        for (int i = 0; i <= 6; i++) {
            String randomChar = charsForPassword.get((int) (Math.random() * charsForPassword.size()));
            randomPassword = randomPassword+randomChar;
        }

    }
}
