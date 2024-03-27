package com.nhnacademy.demoauthservice.service;

import com.nhnacademy.demoauthservice.adaptor.UserServiceAdaptor;
import com.nhnacademy.demoauthservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserServiceAdaptor userServiceAdaptor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userServiceAdaptor.getUser(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPw(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
