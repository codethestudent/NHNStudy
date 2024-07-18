package com.junyeongha;

public class Fibonacci {
    // TODO: 재귀적으로 동작하는 피보나치 함수를 구현하세요.
    public static int fibonacci(int n) {
        // 문제
        return 0;
    }

    public static int answer(int n) {
        // basis
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // recursion starts
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
