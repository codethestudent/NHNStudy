package com.nhnacademy.counter;

public class RunnableCounter implements Runnable{
    private String name;
    private int maxCount;
    private int count;
    Thread thread;

    public RunnableCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
        this.thread = new Thread(this);
    }

    public void start(){
        thread.start();
    }
    @Override
    public void run() {
        thread = Thread.currentThread();
        for(int i=0; i<maxCount; i++){
            try{
                Thread.sleep(1000);
                System.out.println(name + " : "+ count++);
                System.out.println(Thread.currentThread());
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public Thread getThread(){
        return thread;
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableCounter("runnableCounter",10));
        Thread thread2 = new Thread(new RunnableCounter("runnableCounter",10));
        
        thread1.start();
        thread2.start();
    }
}
