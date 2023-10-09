package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String ipAddress = "10.1.1.100";
        int port = 1234;

        try (BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            System.out.print("~$ ");
            while (true) {
                line = commandReader.readLine();
                if ("exit".equals(line)) {
                    break;
                }
                if (("snc " + ipAddress + " " + port).equals(line)) {
                    // client mode
                    System.out.println("client mode !");
                    Client client = new Client(port);
                    client.start();
                } else if (("snc -l " + port).equals(line)) {
                    // server mode
                    System.out.println("server mode !");
                    Server server = new Server(port);
                    server.start();
                } else {
                    System.out.print("~$ ");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}