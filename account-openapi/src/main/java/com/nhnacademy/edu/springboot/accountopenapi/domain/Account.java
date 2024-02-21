package com.nhnacademy.edu.springboot.accountopenapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String user;
    private String number;
    private Integer balance;
}
