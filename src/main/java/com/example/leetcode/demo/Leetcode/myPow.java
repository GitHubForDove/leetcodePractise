package com.example.leetcode.demo.Leetcode;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-26
 * @descript https://www.cnblogs.com/grandyang/p/4383775.html
 */
public class myPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.1,-7));
        System.out.println(myPow2(2.1,-7));

    }

    public static double myPow(double x, int n) {

        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double myPow2(double x, int n) {
        double res = 1.0;

        while (n>0) {
            if ((n&1) == 1) {
                res *= x;
            }
            n >>>= 1;
            x *= x;
        }
        return res < 0 ? 1 / res : res;
    }
}
