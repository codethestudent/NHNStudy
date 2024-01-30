package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;

    public MessageSendService() {
    }

    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender, @Value("${phoneNumber}") String phoneNumber) {
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
