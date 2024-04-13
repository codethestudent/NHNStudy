package com.nhnacademy.demofront1.adaptor;

import com.nhnacademy.demofront1.domain.LoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "user-service")
public interface SignupAdaptor {
    @PostMapping("/signup")
    void doSignup(LoginDto loginDto);
}
