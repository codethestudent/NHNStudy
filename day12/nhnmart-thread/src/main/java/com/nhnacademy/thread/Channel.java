package com.nhnacademy.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Channel {
    private final Queue<Request> queue;
    private final int queueSize;
    public Channel(int queueSize){
        this.queueSize = queueSize;
        queue = new LinkedList<>();
    }

    public synchronized Request getRequest() throws InterruptedException {

        while(queue.isEmpty()){
            wait();
        }
        Request request = queue.poll();
        notifyAll();

        return request;
    }

    public synchronized void addRequest(Request request){
        while(queue.size()>=queueSize){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        queue.add(request);
        notifyAll();
    }
}
