package com.nhnacademy.demoauthservice.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceClientTest {

    @Autowired
    UserServiceClient userServiceClient;

    @Test
    void retrieveUserDetail() {
        Map<String, Object> test = userServiceClient.retrieveUserDetail("test");
        System.out.println(test);
    }
}