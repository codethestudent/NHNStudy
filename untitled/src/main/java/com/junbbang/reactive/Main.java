package com.junbbang.reactive;

import org.reactivestreams.Subscriber;

public class Main {
    public static void main(String[] args) {
        MyPub myPub = new MyPub();
        MySub mySub = new MySub();

        myPub.subscribe(mySub);
    }
}