package com.example.leetcode.demo.Offer;


/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {


    public static int numberOf1(int n) {

        int res = 0;

        while (n != 0) {
            res++;
            n = n & (n-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(4));
    }
}
