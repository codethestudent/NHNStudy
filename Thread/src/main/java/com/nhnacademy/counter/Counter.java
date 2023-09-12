package com.nhnacademy.counter;

public class Counter {
    private String threadName;
    private int maxCount;
    private int counter;

    public Counter(String threadName, int maxCount){
        this.threadName = threadName;
        this.maxCount = maxCount;
        counter = 0;
    }
    public void run() {
        for(int i=0; i<maxCount; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " " + counter++);
        }
    }
    public static void main(String[] args) {
        String thread1 = "asdf";
        Counter counter =  new Counter(thread1, 10);
        counter.run();
    }
}
