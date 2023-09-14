package com.nhnacademy;

public class Counter {
    int maxCount;
    String name;
    int count;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
    }

    public void run() {
        for (int i = 0; i <= maxCount; i++) {
            try {
                count++;
                System.out.println(count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter("threadNull", 10);
        c.run();
    }
}
