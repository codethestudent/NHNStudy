package com.nhnacademy.demoauthservice.adaptor;

import com.nhnacademy.demoauthservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(value = "user-service", path = "/users")
public interface UserServiceAdaptor {
    @GetMapping("/{userId}/details")
    Optional<User> getUser(@PathVariable(name = "userId") String id);
}
