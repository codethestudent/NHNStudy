package com.nhnacademy.doItMySelf;

public class RunnableCounter implements Runnable {
    private String name;
    private int maxCount;
    private int count;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                Thread.sleep(1000);
                count++;
                System.out.println(name + " : " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Runnable Counter finished");
    }

}
