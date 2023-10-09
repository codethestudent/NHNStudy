package com.nhnacademy.server;

import java.io.BufferedInputStream;
import java.io.IOException;

public class Receiver implements Runnable {
    Thread thread;
    BufferedInputStream inputStream;
    // BufferedOutputStream outputStream;

    public Receiver(BufferedInputStream inputStream) {
        this.thread = new Thread(this, "receiver thread");
        this.inputStream = inputStream;
        // this.outputStream = outputStream;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        System.out.println("thread started");
        try {
            int length;
            while ((length = inputStream.read(buffer)) >= 0) {
                System.out.println(new String(buffer, 0, length));
                // outputStream.write(buffer);
                // outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
