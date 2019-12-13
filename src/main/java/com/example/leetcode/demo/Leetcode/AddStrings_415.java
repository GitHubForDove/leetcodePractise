package com.example.leetcode.demo.Leetcode;


/**
 *  leetcode 415. 字符串相加
 *
 *  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 */
public class AddStrings_415 {

    public static String addStrings(String num1, String num2) {
        if (num1== null || num2 == null) {
            return num1 == null ? num1 : num2;
        }

        int n = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder res = new StringBuilder();
        while (len1 >0 || len2>0) {

            int a = len1>0 ? num1.charAt(len1-1) - '0' : 0;
            int b = len2>0 ? num2.charAt(len2-1) - '0' : 0;
            int sum = a+b + n;
            n = sum / 10;
            res.append(sum % 10);
            len1--;
            len2--;
        }

        if (n > 0) {
            res.append(n);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "6", num2 = "501";
        String res = addStrings(num1, num2);
        System.out.println(res);
    }
}
