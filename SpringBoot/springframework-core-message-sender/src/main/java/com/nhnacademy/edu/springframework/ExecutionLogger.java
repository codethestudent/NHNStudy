package com.nhnacademy.edu.springframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class ExecutionLogger {
    @Around("execution(public void com.nhnacademy.edu.springframework.MessageSender.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object returnValue = joinPoint.proceed();

        stopWatch.stop();
        System.out.println(joinPoint);
        System.out.println("joinPoint.getArgs() : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println(stopWatch.prettyPrint());
        System.out.println(joinPoint.getSignature().getName() + " 실행 시간: " + stopWatch.getTotalTimeMillis() + "ms");

        return returnValue;
    }
}
