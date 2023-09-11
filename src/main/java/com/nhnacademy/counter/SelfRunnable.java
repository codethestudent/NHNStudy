package com.nhnacademy.counter;

public class SelfRunnable implements Runnable {
    private String name;
    private int maxCount;
    private int count;
    Thread thread;

    public SelfRunnable(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
        this.thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    public boolean isRunning() {
        return thread.isAlive();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        // 아래와 같은 방법으로 스레드를 멈출 수 있음 1, 2
        // for (int i = 0; i < maxCount; i++) {
        //     if (!Thread.currentThread().isInterrupted()) {
        //         try {
        //             Thread.sleep(1000);
        //             System.out.println(name + " : " + count++);
        //         } catch (InterruptedException e) {
        //             Thread.currentThread().interrupt();
        //         }
        //     }
        // }
        try {
            for (int i = 0; i < maxCount; i++) {
                Thread.sleep(1000);
                System.out.println(name + " : " + count++);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("finished");
    }

    public Thread getThread() {
        return thread;
    }

    public static void main(String[] args) throws InterruptedException {
        SelfRunnable thread1 = new SelfRunnable("runnableCounter1", 10);
        SelfRunnable thread2 = new SelfRunnable("runnableCounter2", 10);

        thread1.start();
        thread2.start();

        Thread.sleep(5000);
        thread1.stop();
    }
}
