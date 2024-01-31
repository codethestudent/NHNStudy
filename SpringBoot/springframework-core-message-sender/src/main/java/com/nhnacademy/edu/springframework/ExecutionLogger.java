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
    @Around("execution(public void com.nhnacademy.edu.springframework.MessageSender.sendMessage(User, String))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object returnValue = joinPoint.proceed();

        stopWatch.stop();
        System.out.println(Arrays.toString(Arrays.stream(joinPoint.getArgs()).toArray()));
        System.out.println(joinPoint.getSignature().getName() + " 실행 시간: " + stopWatch.getTotalTimeMillis() + "ms");

        return returnValue;
    }
}
