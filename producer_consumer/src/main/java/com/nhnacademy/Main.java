package com.nhnacademy;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("a");
        Semaphore b = new Semaphore(1);
        thread.wait(1000);
        System.out.println("try : " + b.tryAcquire(1));
        System.out.println("left : " + b.availablePermits());
        System.out.println("wait : " + thread.getState());
    }
}
