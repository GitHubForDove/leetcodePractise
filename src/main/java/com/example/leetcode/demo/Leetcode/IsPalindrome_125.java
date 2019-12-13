package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome_125 {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        char[] chas = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i=0; i < chas.length; i++) {
            if ((chas[i] <= 'z' && chas[i] >= 'a')
                    || (chas[i] <= 'Z' && chas[i] >= 'A')
                    || (chas[i] >= '0') && chas[i]<= '9') {
                temp.append(chas[i]);
            }
        }
        s = temp.toString().toLowerCase();
        int i=0, j=s.length()-1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        IsPalindrome_125 ip = new IsPalindrome_125();
        boolean res = ip.isPalindrome(s);
        System.out.println(res);
    }

}
