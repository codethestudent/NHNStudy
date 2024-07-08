package com.junbbang.simpletelegraf.controller;

import com.junbbang.simpletelegraf.service.MqttReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MqttController {
    private final MqttReceiver mqttReceiver;

    @GetMapping("/stream/messages")
    public Flux<String> streamMessages() {
        return mqttReceiver.getMessages();
    }
}
