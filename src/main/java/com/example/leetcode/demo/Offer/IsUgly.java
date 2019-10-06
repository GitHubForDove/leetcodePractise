package com.example.leetcode.demo.Offer;

/**
 * 编写一个程序判断给定的数是否为丑数。
 */
public class IsUgly {


    public static boolean isUgly(int num) {

        if (num < 1) {
            return false;
        }

        while (num % 2 == 0) {

            num = num/2;
        }

        while (num % 3 == 0) {

            num = num/3;
        }

        while (num % 5 == 0) {

            num = num/5;
        }

        if (num == 1) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
}
