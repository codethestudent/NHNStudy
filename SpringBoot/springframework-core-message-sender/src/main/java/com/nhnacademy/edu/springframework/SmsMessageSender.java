package com.nhnacademy.edu.springframework;

public class SmsMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println(user.getPhoneNumber() + ":" + message);
    }
}
