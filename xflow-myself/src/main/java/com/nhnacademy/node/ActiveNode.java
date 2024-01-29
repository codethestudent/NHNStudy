package com.nhnacademy.node;

import com.nhnacademy.message.Message;

public abstract class ActiveNode extends Node implements Runnable {
    public static final long DEFAULT_INTERVAL = 1;
    Thread thread;

    long interval = DEFAULT_INTERVAL;

    ActiveNode() {
        super();
        thread = new Thread(this, getId());
    }

    ActiveNode(String name) {
        this();
        setName(name);
    }

    public Message process(Message message) {
        return message;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public synchronized void start() {
        if (thread != null) {
            throw new RuntimeException();
        }

        thread = new Thread(this, getName());
        thread.start();
    }

    public synchronized void stop() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override
    public String getName() {
        return thread.getName();
    }

    @Override
    public void setName(String name) {
        thread.setName(name);
    }

    void preprocess() {
        //
    }

    void process() {
        //
    }

    synchronized void postprocess() {
        thread = null;
    }

    public synchronized boolean isAlive() {
        return (thread != null) && thread.isAlive();
    }

    @Override
    public void run() {
        preprocess();

        long startTime = System.currentTimeMillis();
        long previousTime = startTime;

        while (isAlive()) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;

            if (elapsedTime < interval) {
                try {
                    process();
                    Thread.sleep(interval - elapsedTime);
                } catch (InterruptedException e) {
                    stop();
                }
            }

            previousTime = startTime + (System.currentTimeMillis() - startTime) / interval * interval;
        }

        postprocess();
    }

}
