package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework"})
@PropertySource("classpath:name.properties")
@EnableAspectJAutoProxy
public class MainConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
