package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {

    @Bean("smsMessageSender")
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }
}
