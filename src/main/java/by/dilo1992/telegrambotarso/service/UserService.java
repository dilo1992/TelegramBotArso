package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.converter.ConverterFromUserDtoToUser;
import by.dilo1992.telegrambotarso.converter.ConverterFromUserToUserDto;
import by.dilo1992.telegrambotarso.dto.UserDto;
import by.dilo1992.telegrambotarso.entity.Role;
import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.repository.RoleRepository;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConverterFromUserToUserDto converterFromUserToUserDto;
    private final ConverterFromUserDtoToUser converterFromUserDtoToUser;

//    public void save(AuthRequest authRequest) {
//        UserDto userDto = new UserDto();
//        userDto.setRoleId(1L); //устанавливаем чтоб по дефолту
//        // сразу у пользователей авторизованных будут USER (2 номер из таблицы)
//        userDto.setLogin(authRequest.getLogin());
//        userDto.setPassword(authRequest.getPassword());
//        save(userDto);
//    }

    @Transactional
    public UserDto save(UserDto userDto) { //в методе сразу
        long roleId = userDto.getRoleId();
        Role role = roleRepository
                .findById(roleId)
                .orElseThrow();

        User user = converterFromUserDtoToUser.convert(userDto); //конвертировали из приходящих

        User userFromDatabase = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if (userFromDatabase != null) {
            return userDto;
        } else {
            // данных в объект user
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword())); //шифруем пароль
            userRepository.save(user);
            return converterFromUserToUserDto.convert(user);
        }
    }

    public Optional<User> findByLogin(String username) {
        return userRepository.findByUsername(username);
    }

//    public User getTokenForUserIfExists(AuthRequest authRequest) {
//        return findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword())
//                .orElseThrow();
////        return tokenUtil.generateToken(user.getLogin()); //если нашел для user логин и пароль, то создаем токен
//    }

    public Optional<User> findByLoginAndPassword(String login, String password) { //эти данные приходят с фронта
        User user = findByLogin(login).orElseThrow();
        if (passwordEncoder.matches(password, user.getPassword())) {
            //если наш пароль неизмененный равен уже зашифрованному, то возвращаем user
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
