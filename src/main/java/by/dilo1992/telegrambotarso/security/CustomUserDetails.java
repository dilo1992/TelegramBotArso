package by.dilo1992.telegrambotarso.security;

import by.dilo1992.telegrambotarso.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isActive;

    //аналогия конвертера - из объекта класса user делаем объект класса CustomUserDetails
    public static CustomUserDetails getUserDetailsFromUser(User user) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.username = user.getUsername();
        userDetails.password = user.getPassword();
        userDetails.authorities = Collections
                .singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        userDetails.isActive = user.isActive();
        return userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
