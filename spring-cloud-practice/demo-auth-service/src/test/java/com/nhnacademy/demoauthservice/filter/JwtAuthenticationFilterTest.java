package com.nhnacademy.demoauthservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.demoauthservice.auth.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class JwtAuthenticationFilterTest {

    @Mock
    JwtTokenProvider jwtTokenProvider;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    ObjectMapper objectMapper;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
    @InjectMocks
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void attemptAuthentication() {

        when(authenticationManager.authenticate()).thenReturn(any(Authentication.class));
    }

    @Test
    void successfulAuthentication() {
    }
}