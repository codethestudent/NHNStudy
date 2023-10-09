package com.nhnacademy.thread;

import com.nhnacademy.mart.employee.EmployeeGenerator;

public class WorkerPool {
    private final Worker[]  workers;

    public WorkerPool(int threadCount, Channel channel){
        workers = new Worker[threadCount];
        for(int i=0; i<workers.length; i++){
            workers[i] = new Worker(channel, EmployeeGenerator.getEmployeeGenerator().next());
        }
    }
    
    public void start(){
        for (Worker worker : workers) {
            new Thread(worker).start();
        }
    }

}
