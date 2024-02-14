package com.nhnacademy.thread;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Request {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    private final long requestId;

    protected Request() {
        this.requestId = ID_GENERATOR.incrementAndGet();
    }

    protected abstract void execute();

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                '}';
    }
}
