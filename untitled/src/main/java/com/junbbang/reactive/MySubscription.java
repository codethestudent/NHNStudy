package com.junbbang.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

public class MySubscription implements Subscription {
    private Subscriber subscriber;
    private Iterator<Integer> it;

    public MySubscription(Subscriber<? super Integer> subscriber, Iterable<Integer> its) {
        this.subscriber = subscriber;
        this.it = its.iterator();
    }

    @Override
    public void request(long l) {
        while (l > 0) {
            if (it.hasNext()) {
                subscriber.onNext(it.next());
            } else {
                subscriber.onComplete();
                break;
            }
            l--;
        }
    }

    @Override
    public void cancel() {

    }
}
