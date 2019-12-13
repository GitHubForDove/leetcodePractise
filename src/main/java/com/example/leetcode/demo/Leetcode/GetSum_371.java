package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 371. 两整数之和
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 */
public class GetSum_371 {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int res = (a&b) << 1;
            a = a^b;
            b = res;
        }
        return a;
    }

    public static void main(String[] args) {
        int res = getSum(3,3);
        System.out.println(res);
    }
}
