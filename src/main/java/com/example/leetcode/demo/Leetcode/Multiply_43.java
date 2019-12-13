package com.example.leetcode.demo.Leetcode;


/**
 * 43 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Multiply_43 {


    /**
     * 优秀的解法
     */
    public static String multiply(String num1, String num2) {

        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        if(n1 < 0 || n2 < 0) return "";
        int[] mul = new int[n1+n2+2];

        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                // 先加低位判断是否有新的进位
                bitmul += mul[i+j+1];

                mul[i+j] += bitmul / 10;
                mul[i+j+1] = bitmul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length-1 && mul[i] == 0)
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();

    }

    public static String add(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int len1 = num1Char.length;
        int len2 = num2Char.length;
        int n = 0;
        while (len1 > 0 && len2 > 0) {
            int sum = n +  num1Char[--len1] - '0' + num2Char[--len2] - '0';
            n = sum / 10;
            sb.append(sum%10);
        }
        if (len1 > 0) {
            while (len1>0) {
                int sum = n + num1Char[--len1] - '0';
                n = sum / 10;
                sb.append(sum%10);
            }
        }

        if (len2 > 0) {
            while (len2>0) {
                int sum = n + num2Char[--len2] - '0';
                n = sum / 10;
                sb.append(sum%10);
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "12356888888888";
        String num2 = "345688888888888888888888";
        String res = multiply(num1, num2);
        System.out.println(res);
    }
}
