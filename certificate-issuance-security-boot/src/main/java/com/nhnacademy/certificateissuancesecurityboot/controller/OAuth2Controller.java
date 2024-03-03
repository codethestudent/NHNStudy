package com.nhnacademy.certificateissuancesecurityboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OAuth2Controller {

    private final RedisTemplate<Object, Object> redisTemplate;
    private final ResidentService residentService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String clientId = "9a9aa23a0e42cf87eff4";
    private final String redirectUri = "http://localhost:8080/login/oauth2/code/github";

    @GetMapping("/login/github")
    public String redirectToGithub() {
        return "redirect:https://github.com/login/oauth/authorize?client_id=" + clientId + "&redirect_uri=" + redirectUri;
    }

    @GetMapping("/login/oauth2/code/github")
    public String githubCallback(@RequestParam("code") String code,
                                 HttpServletResponse response) throws JsonProcessingException {
        HttpHeaders accessTokenHeader = new HttpHeaders();
        accessTokenHeader.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", "c19e904b3aa65a1b1d3ad349a6270979a7f754a4");
        params.put("code", code);
        params.put("redirect_uri", redirectUri);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(params, accessTokenHeader);
        ResponseEntity<String> accessTokenResponse = restTemplate.exchange(
                "https://github.com/login/oauth/access_token",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        String[] accessToken1 = Objects.requireNonNull(accessTokenResponse.getBody()).split("&");
        String[] accessToken2 = accessToken1[0].split("=");
        log.warn(accessToken2[1]);

        HttpHeaders userInfoHeader = new HttpHeaders();
        userInfoHeader.set("Authorization", "token " + accessToken2[1]);
        HttpEntity<String> entity = new HttpEntity<>("parameters", userInfoHeader);
        ResponseEntity<String> userInfoResponse = restTemplate.exchange(
                "https://api.github.com/user",
                HttpMethod.GET,
                entity,
                String.class
        );
        String sessionId = UUID.randomUUID().toString();
        String specificValue = getSpecificValueFromResponse(userInfoResponse, "email");
        Cookie cookie;
        log.warn(specificValue);
        if (Objects.nonNull(residentService.getResidentByEmail(specificValue))) {
            Resident resident = residentService.getResidentByEmail(specificValue);
            cookie = saveRedisAndGetCookie(sessionId, resident.getId());
            log.warn("ㅇㅕ기 실행됨");
        } else {
            return "redirect:/logout";
        }
        response.addCookie(cookie);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                specificValue,
                null,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.warn((String) redisTemplate.opsForHash().get(sessionId, "id"));
        return "redirect:/home";
    }

    private String getSpecificValueFromResponse(ResponseEntity<String> responseEntity, String name) throws JsonProcessingException {
        String responseString = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseString);

        return jsonNode.get(name).asText();
    }

    private Cookie saveRedisAndGetCookie(String sessionId, String id) {
        redisTemplate.opsForHash().put(sessionId, "id", id);
        redisTemplate.opsForHash().put(sessionId, "authority", "ROLE_USER");
        Cookie cookie = new Cookie("SESSION", sessionId);
        cookie.setMaxAge(259200);
        cookie.setPath("/");
        return cookie;
    }
}