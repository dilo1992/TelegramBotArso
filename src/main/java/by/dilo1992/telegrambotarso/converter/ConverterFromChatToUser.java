package by.dilo1992.telegrambotarso.converter;

import by.dilo1992.telegrambotarso.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.sql.Timestamp;

@Component
public class ConverterFromChatToUser implements Converter<Message, User> {

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

        return user;
    }
}
