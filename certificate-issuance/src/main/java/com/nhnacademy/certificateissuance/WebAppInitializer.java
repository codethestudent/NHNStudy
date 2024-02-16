package com.nhnacademy.certificateissuance;

import com.nhnacademy.certificateissuance.config.RootConfig;
import com.nhnacademy.certificateissuance.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public Class<?>[] getRootConfigClasses() { // 스프링 컨텍스트 설정 클래스
        return new Class[]{RootConfig.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() { // 서블릿 컨텍스트 설정 클래스 (웹뷰와 관련, 컨트롤러)
        return new Class[]{WebConfig.class};
    }

    @Override
    public String[] getServletMappings() {
        return new String[]{"/"};
    }
}
