package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework"})
@PropertySource("classpath:name.properties")
@EnableAspectJAutoProxy
public class MainConfig {

}
