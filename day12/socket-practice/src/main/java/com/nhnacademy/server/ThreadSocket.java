package com.nhnacademy.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadSocket {

    public static void main(String[] args) throws UnknownHostException, IOException {

        try (Socket socket = new Socket("", 12345);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream())) {
            System.out.println("socket connected ! ");

            Receiver receiver = new Receiver(inputStream);
            receiver.start();

            String line;
            while ((line = reader.readLine()) != null) {
                outputStream.write(line.getBytes());
                outputStream.flush();
                // int length = inputStream.read(buffer);
                // System.out.println(new String(buffer, 0, length));
            }
        } catch (IOException e) {
            System.out.println("error !");
        }
    }
}
