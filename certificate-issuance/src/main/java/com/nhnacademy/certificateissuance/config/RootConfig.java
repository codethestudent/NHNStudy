package com.nhnacademy.certificateissuance.config;

import com.nhnacademy.certificateissuance.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class, excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/certificateissuancedatabase");
        dataSource.setUsername("root");
        dataSource.setPassword("Wnsdudgk4917@");
        dataSource.setInitialSize(5); // 초기 커넥션 풀 사이즈
        dataSource.setMaxTotal(10); // 최대 커넥션 풀 사이즈
        return dataSource;
    }
}
