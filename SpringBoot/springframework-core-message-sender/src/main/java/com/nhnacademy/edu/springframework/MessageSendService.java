package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;

    public MessageSendService() {
    }

    public MessageSendService(MessageSender messageSender, String phoneNumber) {
        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
    }

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }


    public void doSendMessage(User user, String message) {
        user.setPhoneNumber(phoneNumber);
        messageSender.sendMessage(user, message);
    }

    public void setMessageSender(MessageSender messageSender) {
        System.out.println("setMessageSender invoked !!");
        this.messageSender = messageSender;
    }
}
