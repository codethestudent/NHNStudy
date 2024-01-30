package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class ServiceConfig {

}
