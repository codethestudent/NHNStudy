package com.nhnacademy;

public class SharedMain {
    public static void main(String[] args) throws InterruptedException {
        SharedCount c1 = new SharedCount();
        SharedCounter sc1 = new SharedCounter("shared counter 1", 10000, c1);
        SharedCounter sc2 = new SharedCounter("shared counter 2", 10000, c1);

        sc1.start();
        sc2.start();
        System.out.println(sc1.getState());
        System.out.println(sc2.getState());
        System.out.println(sc1.getName() + " : started");
        System.out.println(sc2.getName() + " : started");

        sc1.join();
        sc2.join();
        System.out.println(sc1.getState());
        System.out.println(sc2.getState());

        System.out.println(c1.getCount());
    }
}
