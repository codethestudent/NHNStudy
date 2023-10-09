package com.nhnacademy;

public class SharedCounter extends Thread {
    int count;
    int maxCount;
    SharedCount sharedCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        count = 0;
    }

    @Override
    public void run() {
        System.out.println(currentThread().getState());
        while (count < maxCount) {
            count++;
            sharedCount.increment();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Thread getThread() {
        return this;
    }
}
