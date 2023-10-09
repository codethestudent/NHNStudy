package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    Thread thread;
    int port;

    public Server(int port) {
        this.port = port;
        thread = new Thread(this, "server thread");
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();
                BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream(), port);
                BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream(), port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("server to client connected");
            byte[] buffer = new byte[2048];
            while (true) {
                System.out.println(new String(buffer, 0, inputStream.read()));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
