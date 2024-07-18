package com.junyeongha;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciMemoizationTest {

    @Test
    public void doTest() {
        Assert.assertEquals(0, FibonacciMemoization.fibonacci(0));
        FibonacciMemoization.memo = null;
        Assert.assertEquals(1, FibonacciMemoization.fibonacci(1));
        FibonacciMemoization.memo = null;
        Assert.assertEquals(55, FibonacciMemoization.fibonacci(10));
        FibonacciMemoization.memo = null;
        Assert.assertEquals(89, FibonacciMemoization.fibonacci(11));
        FibonacciMemoization.memo = null;
    }

    @Test
    public void memoTest() {
        FibonacciMemoization.fibonacci(10);
        FibonacciMemoization fibonacciMemoization = new FibonacciMemoization();
        Assert.assertEquals(0, fibonacciMemoization.memo[0]);
        Assert.assertEquals(0, fibonacciMemoization.memo[1]);
        Assert.assertEquals(1, fibonacciMemoization.memo[2]);
        Assert.assertEquals(2, fibonacciMemoization.memo[3]);
        Assert.assertEquals(3, fibonacciMemoization.memo[4]);
        Assert.assertEquals(5, fibonacciMemoization.memo[5]);
        Assert.assertEquals(8, fibonacciMemoization.memo[6]);
        Assert.assertEquals(13, fibonacciMemoization.memo[7]);
        Assert.assertEquals(21, fibonacciMemoization.memo[8]);
        Assert.assertEquals(34, fibonacciMemoization.memo[9]);
        Assert.assertEquals(55, fibonacciMemoization.memo[10]);
    }
}
