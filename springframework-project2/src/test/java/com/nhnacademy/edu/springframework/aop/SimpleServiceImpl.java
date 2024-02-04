package com.nhnacademy.edu.springframework.aop;

import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import org.springframework.stereotype.Component;

@Component
public class SimpleServiceImpl implements SimpleService {
    private boolean taskPerformed = false;

    @Override
    @MeasureExecutionTime
    public void performTask() {
        try {
            Thread.sleep(1000);
            taskPerformed = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isTaskPerformed() {
        return taskPerformed;
    }
}
