package com.nhnacademy.edu.springframework;

public class EmailMessageSender implements MessageSender {

    public EmailMessageSender() {
        System.out.println("EmailMessageSender Initiated !!");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println(message + user.getEmail());
    }

    private void cleanup() {
        System.out.println("destroy method called in EmailMessageSender");
    }
}
