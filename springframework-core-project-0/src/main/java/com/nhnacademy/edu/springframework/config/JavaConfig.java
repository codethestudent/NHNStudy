package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.aop.ExecutionTimeAspect;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.DoorayHookSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework"})
@PropertySource("classpath:names.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
