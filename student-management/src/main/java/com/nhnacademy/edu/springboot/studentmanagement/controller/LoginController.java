package com.nhnacademy.edu.springboot.studentmanagement.controller;

import com.nhnacademy.edu.springboot.studentmanagement.domain.LoginRequest;
import com.nhnacademy.edu.springboot.studentmanagement.entity.User;
import com.nhnacademy.edu.springboot.studentmanagement.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping(value = {"/", ""})
    public String loginForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            return "login/loginInfo";
        }
        model.addAttribute("loginRequest", new LoginRequest());
        return "login/loginForm";
    }

    @PostMapping({"/", ""})
    public String doLogin(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginRequest", loginRequest);
            return "login/loginForm";
        }
        User user = loginService.match(loginRequest);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "login/loginInfo";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "redirect:/login/";
        }
    }

    @PostMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            session.invalidate();
            Cookie cookie = new Cookie("JSESSIONID", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/login/";
    }
}
