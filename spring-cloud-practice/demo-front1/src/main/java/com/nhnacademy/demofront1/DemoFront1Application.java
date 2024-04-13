package com.nhnacademy.demofront1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoFront1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoFront1Application.class, args);
    }

}
