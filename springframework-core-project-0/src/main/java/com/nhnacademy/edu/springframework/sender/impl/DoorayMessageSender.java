package com.nhnacademy.edu.springframework.sender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotations.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender {
    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    @MeasureExecutionTime
    public boolean sendMessage(User user, String message) {
        doorayHookSender
                .send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message + user.getPhoneNumber())
                        .build());
        return true;
    }
}
