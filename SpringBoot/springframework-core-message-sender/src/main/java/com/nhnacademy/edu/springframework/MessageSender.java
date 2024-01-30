package com.nhnacademy.edu.springframework;

import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    void sendMessage(User user, String message);
}
