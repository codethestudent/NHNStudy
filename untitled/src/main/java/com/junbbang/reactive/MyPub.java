package com.junbbang.reactive;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        System.out.println("구독자 : 신문 볼게");
        System.out.println("신문사 : 구독정보 만들게 기다려");

        MySubscription subscription = new MySubscription(subscriber, its);

        System.out.println("신문사 : 구독 정보 생성 완료");

        subscriber.onSubscribe(subscription);
    }
}
