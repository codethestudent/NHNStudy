package com.nhnacademy;

public class Producer implements Runnable {
    Thread thread;

    public Producer(String name, Store store) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {

    }

    public String getName() {
        return thread.getName();
    }

}
