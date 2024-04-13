package com.nhnacademy.demofront1.adaptor;

import com.nhnacademy.demofront1.domain.LoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "auth-service", path = "/login")
public interface LoginAdaptor {
    @PostMapping
    void doLogin(@RequestBody LoginDto loginDto);

}
