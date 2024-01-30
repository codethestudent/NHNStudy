package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {
    public static void main(String[] args) {
        User user = new User("asdf@gmail.com", "010-2344-3222");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "message !!");
    }
}
