//package by.dilo1992.telegrambotarso.SORTNEEDED;
//
//import by.dilo1992.telegrambotarso.entity.User;
//import by.dilo1992.telegrambotarso.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByLogin(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User" + username + " not found"));
//
//        return CustomUserDetails.getUserDetailsFromUser(user);
//    }
//}
