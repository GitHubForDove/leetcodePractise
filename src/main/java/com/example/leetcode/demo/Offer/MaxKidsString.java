package com.example.leetcode.demo.Offer;


import java.util.Scanner;

/**
 * 字串最多的次数
 */
public class MaxKidsString {


    public static int maxKidsString(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int maxCount = 0;

        int[] bitmap = new int[26];

        char[] c = str.toCharArray();
        for (int i=0; i<c.length; i++) {
            bitmap[c[i]-'a']++;
            maxCount = Math.max(maxCount, bitmap[c[i]-'a']);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int res = maxKidsString(str);
            System.out.println(res);
        }
    }
}
