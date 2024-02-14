package com.nhnacademy;

public class CounterRunnable implements Runnable {
    static Thread thread;
    int maxCount;
    int count = 0;
    boolean runningFlag;

    public CounterRunnable(String name, int maxCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
        runningFlag = false;
    }

    public void start() {
        System.out.println("thread.getState(): " + thread.getState());
        runningFlag = true;
        thread.start();
    }

    public void stop() {
        runningFlag = false;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            if (runningFlag) {
                try {
                    count++;
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " count : " + count);
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                    Thread.currentThread().interrupt();
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterRunnable cr = new CounterRunnable("theadMy", 10);
        Thread th = new Thread();

        cr.start();
        th.start();
        System.out.println("th.getState(): " + th.getState());

        Thread.sleep(5000);
        cr.stop();
        int activeThreads = Thread.activeCount();
        System.out.println("현재 실행 중인 스레드 개수: " + activeThreads);

        System.out.println("thread.getState(): " + thread.getState());
    }

}
