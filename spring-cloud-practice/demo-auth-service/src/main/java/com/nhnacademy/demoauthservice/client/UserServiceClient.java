package com.nhnacademy.demoauthservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

//@FeignClient(value = "user-service")
public interface UserServiceClient {
    @GetMapping("/users/{userId}/detail")
    Map<String, Object> retrieveUserDetail(@PathVariable String userId);
}
