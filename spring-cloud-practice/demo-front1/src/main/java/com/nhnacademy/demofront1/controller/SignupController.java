package com.nhnacademy.demofront1.controller;

import com.nhnacademy.demofront1.adaptor.SignupAdaptor;
import com.nhnacademy.demofront1.domain.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final SignupAdaptor signupAdaptor;

    @PostMapping
    public void doSignup(@RequestBody LoginDto loginDto) {
        signupAdaptor.doSignup(loginDto);
    }
}
