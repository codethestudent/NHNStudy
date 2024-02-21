package com.nhnacademy.edu.springboot.accountopenapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "com.nhnacademy.account")
@Data
public class AccountAdaptorProperties {
    @NotBlank
    private String address;
}
