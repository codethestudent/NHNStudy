package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;
import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    boolean sendMessage(User user, String message);
}
