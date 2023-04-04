package by.dilo1992.telegrambotarso.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {

    private String login;
    private String password;
    private Long roleId;
}
