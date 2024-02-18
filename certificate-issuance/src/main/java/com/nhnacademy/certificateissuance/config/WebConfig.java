package com.nhnacademy.certificateissuance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.certificateissuance.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
    private final ObjectMapper jsonMapper;
    private final ObjectMapper xmlMapper;

    public WebConfig(ObjectMapper jsonMapper, ObjectMapper xmlMapper) {
        this.jsonMapper = jsonMapper;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(MappingJackson2HttpMessageConverter.class::isInstance);
        converters.removeIf(MappingJackson2XmlHttpMessageConverter.class::isInstance);

        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        MappingJackson2XmlHttpMessageConverter xmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();

        jackson2HttpMessageConverter.setObjectMapper(jsonMapper);
        xmlHttpMessageConverter.setObjectMapper(xmlMapper);

        converters.add(jackson2HttpMessageConverter);
        converters.add(xmlHttpMessageConverter);
    }
}
