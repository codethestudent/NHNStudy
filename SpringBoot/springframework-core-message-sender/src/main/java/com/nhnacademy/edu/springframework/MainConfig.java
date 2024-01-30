package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework"})
@PropertySource("classpath:name.properties")
public class MainConfig {
//    @Value("${phoneNumber}")
//    String phoneNumber;
//
//    @Bean("smsMessageSender")
//    public MessageSender smsMessageSender() {
//        return new SmsMessageSender();
//    }
//
//    @Bean("emailMessageSender")
//    public MessageSender emailMessageSender() {
//        return new EmailMessageSender();
//    }
//
//    @Bean("messageSendService")
//    public MessageSendService messageSendService() {
//        return new MessageSendService(smsMessageSender());
//    }
//
//    @Bean("messageSendService1")
//    public MessageSendService messageSendService1() {
//        return new MessageSendService(smsMessageSender(), phoneNumber);
//    }
}
