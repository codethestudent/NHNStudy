package com.nhnacademy.edu.springboot.accountopenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AccountOpenapiApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AccountOpenapiApplication.class);
		application.run(args);
	}

}
