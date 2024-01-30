package com.nhnacamey;

public class Singleton {
    private static class singleInstanceHolder {
        static {
            System.out.println("내부 클래스 초기화 됨 ! ");
        }

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return singleInstanceHolder.INSTANCE;
    }
}
