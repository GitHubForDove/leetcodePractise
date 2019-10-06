package com.example.leetcode.demo.XinDongFang;

import java.util.Scanner;

public class Question2 {

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex,
                                    char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {

            if (str[strIndex] == pattern[patternIndex] && strIndex != str.length
                    || pattern[patternIndex] == '.' || pattern[patternIndex] == '+' && strIndex != str.length) {
                return matchCore(str, strIndex, pattern, patternIndex+2) ||
                        matchCore(str, strIndex+1, pattern, patternIndex+2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        } else if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '?'){
            if (str[strIndex] == pattern[patternIndex] && strIndex != str.length
                    || pattern[patternIndex] == '.' || pattern[patternIndex] == '+' && strIndex != str.length) {
                return matchCore(str, strIndex, pattern, patternIndex+2) ||
                        matchCore(str, strIndex+1, pattern, patternIndex+2);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }

        if (strIndex != str.length && (str[strIndex] == pattern[patternIndex]
                || pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex+1);
        } else if (strIndex != str.length && (str[strIndex] == pattern[patternIndex]
                || pattern[patternIndex] == '+')){
            return matchCore(str, strIndex+1, pattern, patternIndex+2) ||
                    matchCore(str, strIndex+1, pattern, patternIndex);
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String pattern = sc.next();
            boolean res = match(str.toCharArray(), pattern.toCharArray());
            System.out.println(res);
        }
    }
}
