package com.nhnacademy.edu.springframework.sender.impl;

import com.nhn.dooray.client.DoorayHook;
import org.springframework.web.client.RestTemplate;

public class DoorayHookSender {
    private final RestTemplate restTemplate;
    private final String url;


    public DoorayHookSender(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(DoorayHook builder) {
        restTemplate.postForObject(url, builder, String.class);
    }
}
