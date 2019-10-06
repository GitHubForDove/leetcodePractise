package com.example.leetcode.demo.Offer;


import java.util.Scanner;

/**
 * 最长回文子串
 */
public class LongestPalindrome {


    /**
     * 有几种解法：
     * 1、暴力破解  --->>> 双重循环破解 时间复杂度为o(n2)
     * 2、动态规划  --->>> dp[i][j] = {
     *                                  str[i] = str[j]  i-j=1
     *                                  str[i] = str[j] && dp[j+1][i-1], i-j>1
     *                               }
     * 3、使用双指针 从字串中心触发 判断是否是回文串 分两种情况 偶数和基数 最大的长度就是 i-j+1的长度
     *
     */

    public static String longestPalindrome(String str) {

        if (str.length() == 0) {
            return "";
        }

        boolean[][] dp = new boolean[str.length()][str.length()];
        int maxLen = 1;
        int start = 0;      //保存最长回文子串起点
        for (int i=0; i<str.length(); i++) {
            for (int j=0; j<=i; j++) {

                if ((i-j) < 2 ) {
                    dp[j][i] = str.charAt(i) == str.charAt(j);
                } else {
                    dp[j][i] = (str.charAt(i) == str.charAt(j)) && dp[j+1][i-1];
                }

                if (dp[j][i] && maxLen < i-j+1) {
                    maxLen = i-j+1;
                    start = j;
                }
            }
        }

        return str.substring(start, start + maxLen);
    }


    public static String longestPalindrome2(String str) {

        if (str.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<str.length(); i++) {

            int res1 = isPalindrome(str, i, i);
            int res2 = isPalindrome(str, i,i+1);
            int len = Math.max(res1, res2);
            if (len > end - start) {
                start = i-(len-1)/2;
                end = i + len/2;
            }
        }
        return str.substring(start, end + 1);
    }

    public static int isPalindrome(String str, int left, int right) {

        int L = left;
        int R = right;

        while (L >= 0 && R<str.length() && (L <= R) && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            System.out.println(longestPalindrome(str));
        }
    }


}
