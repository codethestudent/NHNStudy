package com.junyeongha;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void doTest() {
        Assert.assertEquals(0, Fibonacci.fibonacci(0));
        Assert.assertEquals(1, Fibonacci.fibonacci(1));
        Assert.assertEquals(55, Fibonacci.fibonacci(10));
        Assert.assertEquals(89, Fibonacci.fibonacci(11));
    }
}
