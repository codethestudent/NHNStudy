package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("aaaa@gmail.com", "010-2222-2222");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doSendMessage(user, "hi");
            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doSendMessage(user, "hi");
        }
    }
}