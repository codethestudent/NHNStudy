package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.config.JavaConfig;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.aspectj.bridge.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("하준영", "010-1234-1234");
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)){
            context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "hello dooray~!");
        }
    }
}