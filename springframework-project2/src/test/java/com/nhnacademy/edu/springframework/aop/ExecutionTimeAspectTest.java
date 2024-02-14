package com.nhnacademy.edu.springframework.aop;

import com.nhnacademy.edu.springframework.config.JavaConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExecutionTimeAspectTest {
    @Test
    public void testAspect() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        SimpleService simpleService = context.getBean(SimpleService.class);

        Assertions.assertNotNull(simpleService);

        Assertions.assertFalse(simpleService.isTaskPerformed());
        simpleService.performTask();
        Assertions.assertTrue(simpleService.isTaskPerformed());
    }
}
