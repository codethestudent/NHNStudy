package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("asdf@gmail.com", "010-2344-3222");
//        new MessageSendService(new EmailMessageSender()).doSendMessage(user, "hi");
//        new MessageSendService(new SmsMessageSender()).doSendMessage(user, "hello");

//        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
//            MessageSender smsMessageSender = context.getBean("smsMessageSender", MessageSender.class);
//            MessageSender emailMessageSender = context.getBean("emailMessageSender", MessageSender.class);
//            User user1 = context.getBean("user", User.class);
//
//            MessageSendService messageSendService = new MessageSendService(smsMessageSender);
//            messageSendService.doSendMessage(user1, "hi");
//            messageSendService.doSendMessage(user1, "hi");
//
//            smsMessageSender.sendMessage(user1, "hi");
//            emailMessageSender.sendMessage(user1, "hello");
//        }

//        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
//            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doSendMessage(user, "email !!");
//            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doSendMessage(user, "email !!");
//            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doSendMessage(user, "sms !!");
//            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doSendMessage(user, "sms !!");
//        }

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService messageSendService = context.getBean("messageSendService", MessageSendService.class);
            messageSendService.doSendMessage(user, "hello~ ");
        }
    }
}