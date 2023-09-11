package com.nhnacademy.counter;

public class ThreadCounter extends Thread {
    private String name;
    private int maxCount;
    private int count;

    public ThreadCounter(String name, int maxCount) {
        super(name);
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxCount; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(getName() + " : " + count);
        }
    }

    public static void main(String[] args) {
        ThreadCounter threadCounter = new ThreadCounter("counter", 10);
        threadCounter.start();
    }
}
