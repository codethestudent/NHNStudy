package main;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executor.newFixedThreadPool(10);
    }
}
