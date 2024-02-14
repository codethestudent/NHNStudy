package com.nhnacademy;

public class Consumer implements Runnable {
    Thread thread;
    Store store;

    public Consumer(String name, Store store) {
        thread = new Thread(this, name);
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (store.enter(this)) {
                    store.buy();
                    store.exit(this);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public String getName() {
        return thread.getName();
    }
}
