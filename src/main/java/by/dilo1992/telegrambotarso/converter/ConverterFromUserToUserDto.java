package by.dilo1992.telegrambotarso.converter;

import by.dilo1992.telegrambotarso.dto.UserDto;
import by.dilo1992.telegrambotarso.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterFromUserToUserDto implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
}
