package com.nhnacademy.edu.springboot.studentmanagement.service;

import com.nhnacademy.edu.springboot.studentmanagement.domain.LoginRequest;
import com.nhnacademy.edu.springboot.studentmanagement.entity.User;

public interface LoginService {
    User match(LoginRequest loginRequest);
}