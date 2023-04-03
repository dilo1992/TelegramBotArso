package by.dilo1992.telegrambotarso.converter;

import by.dilo1992.telegrambotarso.dto.UserDto;
import by.dilo1992.telegrambotarso.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterFromUserDtoToUser implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
