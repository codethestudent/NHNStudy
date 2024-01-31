package com.nhnacademy.edu.springframework;

import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender  {

    public EmailMessageSender() {
        System.out.println("EmailMessageSender Initiated !!");
    }

    public void sendMessage(User user, String message) {
        System.out.println(message + user.getEmail());
    }

    private void cleanup() {
        System.out.println("destroy method called in EmailMessageSender");
    }
}
