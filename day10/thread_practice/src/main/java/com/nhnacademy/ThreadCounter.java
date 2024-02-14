package com.nhnacademy;

public class ThreadCounter extends Thread {
    int count;
    int maxCount;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                count++;
                System.out.println(count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCounter tc = new ThreadCounter("thread1", 10);
        tc.start();
    }
}
