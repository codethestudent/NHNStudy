package com.junyeongha;

public class B {
    {
        System.out.println("instance");
    }
    static {
        System.out.println("static");
    }
    public B(){
        System.out.println("B constructor");
    }
}
