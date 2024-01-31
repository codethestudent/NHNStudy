package com.nhnacademy.edu.springframework.sender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotations.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.sender.DoorayHookSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DoorayMessageSender implements MessageSender {
    private final DoorayHookSender doorayHookSender;

    @Autowired
    public DoorayMessageSender(@Qualifier("doorayHookSender") DoorayHookSender doorayHookSender) {
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
