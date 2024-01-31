package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.aop.ExecutionTimeAspect;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.DoorayHookSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:names.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

    @Value("${hookurl}")
    String url;

    @Bean("executionTimeAspect")
    public ExecutionTimeAspect executionTimeAspect() {
        return new ExecutionTimeAspect();
    }

    @Bean("doorayMessageSender")
    public MessageSender doorayMessageSender() {
        return new DoorayMessageSender(doorayHookSender());
    }

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(restTemplate(), url);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageSendService messageSendService() {
        return new MessageSendService(doorayMessageSender());
    }

}
