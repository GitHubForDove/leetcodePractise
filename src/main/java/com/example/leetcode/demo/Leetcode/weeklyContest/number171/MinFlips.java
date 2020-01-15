package com.example.leetcode.demo.Leetcode.weeklyContest.number171;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 5308. 或运算的最小翻转次数 显示英文描述
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 */
public class MinFlips {

    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) {
            return 0;
        }
        int count = 0;
        while (c > 0) {
            int a1 = a & 1;
            int b1 = b & 1;
            int c1 = c & 1;
            if (a1 != c1 && b1 != c1 && a1 == 0) {
                count++;
                a = a >> 1;
                b = b >> 1;
                c = c >> 1;
            } else if (a1 != c1 && b1 != c1 && a1 == 1) {
                count = count + 2;
                a = a >> 1;
                b = b >> 1;
                c = c >> 1;
            } else if ((a1 != c1 || b1 != c1) && c1 == 0) {
                count++;
                a = a >> 1;
                b = b >> 1;
                c = c >> 1;
            }else {
                a = a >> 1;
                b = b >> 1;
                c = c >> 1;
            }
        }

        while (a > 0) {
            int a1 = a & 1;
            if (a1 == 1) {
                count++;
            }
            a = a >> 1;
        }

        while (b > 0) {
            int b1 = b & 1;
            if (b1 == 1) {
                count++;
            }
            b = b >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        MinFlips mf = new MinFlips();
        int res = mf.minFlips(2,6,5);
        System.out.println(res);
    }
}
