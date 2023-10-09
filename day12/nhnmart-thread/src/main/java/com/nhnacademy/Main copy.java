package com.nhnacademy;

import com.nhnacademy.thread.*;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Main {

    public static void main(String[] args) {

        Channel channel = new Channel(20);
        WorkerPool workerPool = new WorkerPool(3,channel);
        workerPool.start();
        log.info("finished!");

        new Thread(new Client(channel)).start();
        new Thread(new Client(channel)).start();
        new Thread(new Client(channel)).start();

    }
}