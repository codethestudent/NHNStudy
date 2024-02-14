package com.nhnacademy;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 스레드로 실행할 코드
        System.out.println("스레드 실행 중...");
    }

    public static void main(String[] args) {
        // Runnable 객체 생성
        MyRunnable myRunnable = new MyRunnable();

        // Thread 객체 생성하고 Runnable 객체 전달
        Thread thread = new Thread(myRunnable);

        // 스레드 시작
        thread.start();
    }
}
