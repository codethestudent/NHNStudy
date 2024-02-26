package com.nhnacademy.security.config;

import com.nhnacademy.security.auth.CustomLoginSuccessHandler;
import com.nhnacademy.security.repository.MemberRepository;
import com.nhnacademy.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/private-project/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                .requestMatchers("/public-project/**").authenticated()
                .requestMatchers("/profile").authenticated()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                .loginPage("/login/process")
                .usernameParameter("usercode")
                .passwordParameter("passcode")
                .loginProcessingUrl("/login/process")
                .successHandler(new CustomLoginSuccessHandler());

        http.logout()
                .logoutUrl("/login/logout")
                .invalidateHttpSession(true)
                .deleteCookies("SESSION");

        http.csrf().disable();

        return http
                .headers(h -> {
                    h.defaultsDisabled();
                    h.contentTypeOptions().disable();
                    h.frameOptions().sameOrigin();
                })
                .build();
    }

    @Bean
    public CustomUserDetailsService userDetailsService(MemberRepository memberRepository) {
        return new CustomUserDetailsService(memberRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
