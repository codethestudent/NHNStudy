package com.nhnacademy.demofront1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
    private String id;
    private String pw;
}
