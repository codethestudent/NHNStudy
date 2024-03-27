package com.nhnacademy.demofront1.adaptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("auth-service")
public interface LoginAdaptor {
    @PostMapping("/login")
    void doLogin();
}
