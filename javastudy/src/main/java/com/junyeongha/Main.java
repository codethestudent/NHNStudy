package com.junyeongha;


import java.util.Arrays;

public class Main {

    static void insert(int[] a, int n, int x) {
        int i = 0;
        while (i < n && a[i] <= x) {
            ++i;
        }
        System.arraycopy(a, i, a, i + 1, n - i);
        a[i] = x;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10, 12, 14};
        insert(a, a.length-1, 9);
        System.out.println(Arrays.toString(a));
    }
}