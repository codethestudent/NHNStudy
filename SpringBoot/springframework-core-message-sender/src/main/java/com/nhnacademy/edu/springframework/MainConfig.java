package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {
    @Value("${phoneNumber}")
    String phoneNumber;

    @Bean("smsMessageSender")
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }

    @Bean("messageSendService")
    public MessageSendService messageSendService() {
        return new MessageSendService(smsMessageSender());
    }

    @Bean("messageSendService1")
    public MessageSendService messageSendService1() {
        return new MessageSendService(smsMessageSender(), phoneNumber);
    }
}
