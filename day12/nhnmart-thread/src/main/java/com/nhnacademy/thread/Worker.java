package com.nhnacademy.thread;

import com.nhnacademy.mart.employee.Employee;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Worker implements Runnable {
    private final Channel channel;
    private final Employee employee;

    public Worker(Channel channel, Employee employee) {
        this.channel = channel;
        this.employee = employee;
    }

    @Override
    public void run() {
        int j=0;
        while (true){

            j++;
            if(j==Integer.MIN_VALUE){
                break;
            }

            Request request = null;
            try {
                request = channel.getRequest();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("직원:{}이 쿠폰을 발급합니다.", employee.getName());
            request.execute();
        }
    }
}
