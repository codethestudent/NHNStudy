package com.nhnacademy;

import java.util.concurrent.Semaphore;

public class Store {
    Semaphore items;
    Semaphore entrance;

    public Store(Semaphore items, Semaphore entrance) {
        this.items = items;
        this.entrance = entrance;
    }

    public synchronized boolean enter(Object object) throws InterruptedException {
        if (entrance.availablePermits() <= 5 && entrance.availablePermits() > 0) {
            if (object instanceof Consumer) {
                if (entrance.tryAcquire()) {
                    System.out.println("<<구매자 스레드>>" + ((Consumer) object).getName() + "입장 하였습니다.");
                    return true;
                }
            } else if (object instanceof Producer) {
                if (entrance.tryAcquire()) {
                    System.out.println("<<판매자 스레드>>" + ((Producer) object).getName() + "입장 하였습니다.");
                    return true;
                }
            }
        } else {
            if (object instanceof Producer) {
                entrance.release();
                System.out.println("판매자 권한 입장");
                return true;
            }
            System.out.println("자리 없음.");
            return false;
        }
        return false;
    }

    public synchronized void exit(Object object) throws InterruptedException {

        if (entrance.availablePermits() <= 5 && entrance.availablePermits() > 0) {
            entrance.release();
            if (object instanceof Consumer) {
                System.out.println("<<구매자 스레드>>" + ((Consumer) object).getName() + "퇴장.");
            } else if (object instanceof Producer) {
                System.out.println("<<판매자 스레드>>" + ((Producer) object).getName() + "퇴장.");
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        if (items.availablePermits() == 0) {
            notify();
            wait();
        }
        items.acquire();
        notify();
        System.out.println("<<구매자>> 구매 성공 !");
    }

    public synchronized void sell(Producer producer) throws InterruptedException {
        if (items.availablePermits() == 10) {
            wait();
            if (enter(producer)) {
                items.release();
                notify();
            }
        }
    }
}
