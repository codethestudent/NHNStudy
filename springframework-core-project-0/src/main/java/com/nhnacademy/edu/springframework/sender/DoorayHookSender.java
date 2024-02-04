package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayHookSender {
    private final RestTemplate restTemplate;
    private final String url;

    @Autowired
    public DoorayHookSender(@Qualifier("restTemplate") RestTemplate restTemplate, @Value("${hookurl}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(DoorayHook builder) {
        restTemplate.postForObject(url, builder, String.class);
    }
}
