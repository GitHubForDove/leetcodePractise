package com.example.leetcode.demo.Offer;


/**
 * 约瑟夫环问题
 */
public class LastRemaining {

    /**
     *  last = (last + m) % i
     */

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;

        for (int i=2; i <= n;i++) {
                last = (last + m) % i;
        }

        return last;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
}
