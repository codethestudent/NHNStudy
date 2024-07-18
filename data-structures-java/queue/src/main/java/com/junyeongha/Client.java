package com.junyeongha;

public class Client {
    private int startTime;
    private int id;

    public Client(int id, int startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public int getStartTime() {
        return this.startTime;
    }
}
