//package by.dilo1992.telegrambotarso.SORTNEEDED;
//
//import by.dilo1992.telegrambotarso.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class CustomUserDetails implements UserDetails {
//
//    private String login;
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    //аналогия конвертера - из объекта класса user делаем объект класса CustomUserDetails
//    public static CustomUserDetails getUserDetailsFromUser(User user) {
//        CustomUserDetails userDetails = new CustomUserDetails();
//        userDetails.login = user.getUsername();
//        userDetails.password = user.getPassword();
//        userDetails.authorities = Collections
//                .singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
//        return userDetails;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
