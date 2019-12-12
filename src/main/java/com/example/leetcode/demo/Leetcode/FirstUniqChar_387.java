package com.example.leetcode.demo.Leetcode;

import java.util.HashMap;

/**
 * leetcode 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 */
public class FirstUniqChar_387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }

        char[] chas = s.toCharArray();
        int[] num = new int[256];
        for (int i=0; i<chas.length; i++) {
            num[chas[i]] ++;
        }

        for (int i=0; i<chas.length; i++) {
            if (num[chas[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "z";
        FirstUniqChar_387 su = new FirstUniqChar_387();
        int res = su.firstUniqChar(s);
        System.out.println(res);
    }
}
