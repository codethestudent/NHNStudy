package com.nhnacademy.edu.springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
public class ExecutionTimeAspect {
    private static final Logger logger = Logger.getLogger(ExecutionTimeAspect.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("elapse.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler.", e);
        }
    }

    @Around("@annotation(com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info(joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        }
    }
}
