package com.junyeongha;

public class FibonacciMemoization {
    // TODO: 피보나치 함수를 재귀적으로 작성하는 것은 같은 연산을 여러번 하게 되는 비용 문제가 있습니다.
    //  이를 해결하기 위해 memoization 을 활용하여 피보나치 함수를 구현하세요.
    public static long[] memo;

    public static long fibonacci(int n) {
        //문제
        return 0;
    }

    public static long answer(int n) {
        if (memo == null) {
            memo = new long[n + 1];
        }
        // basis
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return n;
        }
        // recursion
        memo[n] = answer(n - 1) + answer(n - 2);
        return memo[n];
    }
}
