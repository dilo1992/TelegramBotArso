package by.dilo1992.telegrambotarso.service;


import by.dilo1992.telegrambotarso.entity.User;
import by.dilo1992.telegrambotarso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByLogin(String username) {
        return userRepository.findByUsername(username);
    }
}