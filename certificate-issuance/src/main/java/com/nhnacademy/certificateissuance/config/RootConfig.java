package com.nhnacademy.certificateissuance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.certificateissuance.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class, excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://133.186.244.96:3306/nhn_academy_37");

        dataSource.setUsername("nhn_academy_37");
        dataSource.setPassword("xo-5vMk2*gQpu*f1");

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(10);
        dataSource.setMaxIdle(10);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        executeSqlScripts(dataSource);
        return dataSource;
    }
    private void executeSqlScripts(BasicDataSource dataSource) {
        Resource[] scripts = new Resource[]{
                new ClassPathResource("script/schema.sql"),
        };
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(scripts);
        populator.execute(dataSource);
    }
    @Bean
    public ObjectMapper jsonMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    @Bean
    public ObjectMapper xmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return xmlMapper;
    }
}
