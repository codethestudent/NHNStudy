package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable {
    Thread thread;
    int port;

    public Client(int port) {
        thread = new Thread(this, "client thread");
        this.port = port;
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("", port);
                BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream(), port);
                BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream(), port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("client to server connected");
            while (true) {
                outputStream.write(reader.readLine().getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {

        }
    }
}
