package com.nhnacademy.demofront1.controller;

import com.nhnacademy.demofront1.adaptor.LoginAdaptor;
import com.nhnacademy.demofront1.domain.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginAdaptor loginAdaptor;

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping
    public String doLogin(@RequestBody LoginDto loginDto) {
        log.warn("로그인 시도 프론트");
        loginAdaptor.doLogin(loginDto);
        return null;
    }
}
