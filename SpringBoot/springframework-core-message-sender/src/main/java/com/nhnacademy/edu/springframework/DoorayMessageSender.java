package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender {
    private final RestTemplate restTemplate;
    private final String url;


    public DoorayMessageSender(RestTemplate restTemplate, @Value("${dooray.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        new DoorayMessageSender(new RestTemplate(), url)
                .send(DoorayHook.builder()
                        .botName("하준영")
                        .text("아 겨우했네 ;;")
                        .build());
        return true;
    }

    private void send(DoorayHook build) {
        restTemplate.postForObject(url, build, String.class);
    }
}
