package com.nhnacademy.edu.springboot.studentmanagement.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = "userId is empty")
    private String userId;
    @NotBlank(message = "userPassword  is empty!")
    private String userPassword;
}
