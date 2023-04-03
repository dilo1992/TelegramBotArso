package by.dilo1992.telegrambotarso.converter;

import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.sql.Timestamp;

@Component
@PropertySource("application.properties")
@RequiredArgsConstructor
public class ConverterFromChatToUser implements Converter<Message, User> {

    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${bot.owner}")
    private long ownerId;
    private final RoleRepository roleRepository;

    @Override
    public User convert(Message message) {
        Long id = message.getChatId();
        Chat chat = message.getChat();

        User user = new User();
        user.setId(id);
        user.setFirstname(chat.getFirstName());
        user.setLastname(chat.getLastName());
        user.setUsername(chat.getUserName());
        user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(id.toString()));
        if (id == ownerId) {
            user.setRole(roleRepository.findByName("ROLE_ADMIN"));
        } else {
            user.setRole(roleRepository.findByName("ROLE_USER"));
        }

        return user;
    }

//    private static String createStartingRandomPassword() {
//        String randomPassword = "";
//        List<String> charsForPassword = new ArrayList<>();
//        //добавляем в массив символов буквы
//        for (char c = 'A'; c <= 'z'; c++) {
//            String s = "";
//            s += c;
//            charsForPassword.add(s);
//            if (c == 'Z') {
//                c = 'a' - 1;
//            }
//        }
//        //добавляем в массив символов цифры
//        for (int i = 0; i < 10; i++) {
//            String s = "";
//            s += i;
//            charsForPassword.add(s);
//        }
//
//        //добавляем в строку пароля рандомные символы из массива символов
//        for (int i = 0; i <= 6; i++) {
//            String randomChar = charsForPassword.get((int) (Math.random() * charsForPassword.size()));
//            randomPassword = randomPassword + randomChar;
//        }
//        return randomPassword;
//    }


}