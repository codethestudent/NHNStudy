package com.nhnacademy.demoauthservice.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@Disabled
@ExtendWith(MockitoExtension.class)
class JwtTokenProviderTest {

    @Mock
    private Authentication authentication;

    @InjectMocks
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void createTokenTest() {
        when(authentication.getName()).thenReturn("testUser");
        String token = jwtTokenProvider.createToken(authentication);

        assertNotNull(token);

        String[] tokenParts = token.split("\\.");
        assertEquals(3, tokenParts.length);
        System.out.println(token);
    }
}