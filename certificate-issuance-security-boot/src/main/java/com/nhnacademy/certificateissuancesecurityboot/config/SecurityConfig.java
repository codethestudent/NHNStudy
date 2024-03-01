package com.nhnacademy.certificateissuancesecurityboot.config;

import com.nhnacademy.certificateissuancesecurityboot.auth.CustomLoginSuccessHandler;
import com.nhnacademy.certificateissuancesecurityboot.auth.CustomLogoutSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/home/**").authenticated()
                .antMatchers("/redirect-index").authenticated()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler(null));

        http.logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("SESSION")
                .logoutSuccessHandler(logoutSuccessHandler(null));

        http.csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomLoginSuccessHandler loginSuccessHandler(RedisTemplate<Object, Object> redisTemplate) {
        return new CustomLoginSuccessHandler(redisTemplate);
    }

    @Bean
    public CustomLogoutSuccessHandler logoutSuccessHandler(RedisTemplate<Object, Object> redisTemplate) {
        return new CustomLogoutSuccessHandler(redisTemplate);
    }
}
