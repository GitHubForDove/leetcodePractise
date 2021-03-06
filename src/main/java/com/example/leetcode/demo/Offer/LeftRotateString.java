package com.example.leetcode.demo.Offer;


/**
 * 左旋转字符串
 */
public class LeftRotateString {

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
     * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
     * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */

    public static String leftRotateString(String str,int n) {

        if (str.length() == 0) {
            return "";
        }

        if (n > str.length()) {
            n = n % str.length();
        }

        str = str.substring(n) + str.substring(0,n);

        return str;
    }

    /**
     * 思路：
     * 1.先翻转前半部分
     * 2.再翻转后半部分
     * 3.再对字符串整个进行翻转
     *
     * 考点：不使用库对字符串进行灵活的翻转
     */
    public static String leftRotateString2(String str,int n) {
        if (str == null || str.length() == 0 || n < 0 || n > str.length()) {
            return str;
        }
        char[] ch = str.toCharArray();
        // 进行翻转
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, str.length() - 1);
        reverseString(ch, 0, str.length() - 1);
        return new String(ch);
    }

    /**
     * 对字符数组 ch 的 start 到 end 范围内的字符进行翻转
     */
    public static void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString2(str,3));
    }
}
