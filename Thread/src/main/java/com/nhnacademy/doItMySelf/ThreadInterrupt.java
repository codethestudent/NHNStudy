package com.nhnacademy.doItMySelf;

public class ThreadInterrupt extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread runnableCounter = new Thread(new RunnableCounter("runnable counter", 10));
        runnableCounter.start();
        Thread.sleep(2000);
        Thread.interrupt();
        System.out.println("main finished");
    }
}
