package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import org.springframework.web.client.RestTemplate;

public class DoorayHookSender {
    private RestTemplate restTemplate;
    private String url;


    public DoorayHookSender(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(DoorayHook builder) {
        restTemplate.postForObject(url, builder, String.class);
    }
}
