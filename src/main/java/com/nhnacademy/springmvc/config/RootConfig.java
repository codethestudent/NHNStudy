package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.repository.UserRepository;
import com.nhnacademy.springmvc.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {
    @Bean
    public UserRepository userRepository() {
        log.error("실행되미!!!");
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser("admin", "12345");

        return userRepository;
    }
}
