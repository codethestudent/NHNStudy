package com.nhnacademy.demoauthservice.service;

import com.nhnacademy.demoauthservice.adaptor.UserServiceAdaptor;
import com.nhnacademy.demoauthservice.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserServiceAdaptor userServiceAdaptor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userServiceAdaptor.getUser(username);
        log.warn(userOptional.orElse(null) + "");
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPw(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
