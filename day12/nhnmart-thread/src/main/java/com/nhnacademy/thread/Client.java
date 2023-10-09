package com.nhnacademy.thread;

import com.nhnacademy.customer.CustomerGenerator;

public class Client extends Thread{
    private final Channel channel;

    public Client(Channel channel){
        this.channel = channel;
    }

    @Override
    public void run(){
        int j=0;
        while (true){
            j++;
            if(j==Integer.MIN_VALUE){
                break;
            }

            Request request = new CouponRequest(CustomerGenerator.getCustomerGenerator().next());
            channel.addRequest(request);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);å
            }
        }
    }

}
