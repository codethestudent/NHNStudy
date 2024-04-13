package com.junbbang.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {
    private Subscription subscription;
    private int bufferSize = 3;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("구독자 : 구독 정보 잘 받았어");
        this.subscription = subscription;
        subscription.request(bufferSize);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext() : " + integer);

        bufferSize--;
        if (bufferSize == 0) {
            System.out.println("하루 지남");
            bufferSize = 3;
            subscription.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("구독중에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
