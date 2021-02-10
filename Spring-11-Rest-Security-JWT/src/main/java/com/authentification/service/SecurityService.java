package com.authentification.service;

import com.authentification.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private final UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User foundUser = this.loadUser(s);
        if (foundUser == null) throw new UsernameNotFoundException("User not found: " + s);

        return new org.springframework.security.core.userdetails
                .User(foundUser.getUsername(), foundUser.getPassword(), this.listAuthorities(foundUser));
    }

    private List<GrantedAuthority> listAuthorities(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return grantedAuthorities;
    }

    public User loadUser(String value) {
        boolean isEmail = value.contains("@");
        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }
}
