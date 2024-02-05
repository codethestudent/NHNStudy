package com.nhnacademy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
//    @RequestMapping(method = RequestMethod.GET, value = "/main.do")
    @GetMapping("/main.do")
    public String main() {
        return "main";
    }
}
