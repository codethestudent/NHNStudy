package com.nhnacademy.edu.springframework.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Around("execution(* com.nhnacademy.edu.springframework.project.service..*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long time = System.currentTimeMillis() - startTime;
            System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." +
                    joinPoint.getSignature().getName() + " " + time + "ms");
        }
    }
}
