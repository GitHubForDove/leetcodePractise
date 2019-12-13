package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 76 最小覆盖字串
 *
 *给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class MinWindow_76 {

    public String minWindow(String s, String t) {
        int l = 0, r = -1;
        int res = s.length()+1;
        int begin = 0,end = 0;
        while(l < s.length()) { // s=[l,r]
            if (r+1<s.length() && include(s,t,l,r) == -1) { // 如果不包含T
                r ++;
            } else { // 包含T
                if (include(s,t,l,r) == 1 && res > r-l+1) {
                    begin = l;
                    end = r;
                    res = r-l+1;
                }
                l ++;
            }
        }
        if (res == s.length()+1)
            return "";

        return s.substring(begin,end+1);
    }

    // 判断s[l,r]中是否包含t
    public int include(String s, String t, int l, int r) {
        if (r == -1 || r-l+1 < t.length())
            return -1;
        int[] temp = new int[256];
        String subS = s.substring(l,r+1);
        for(int i = 0 ; i < subS.length() ; i++) {
            temp[subS.charAt(i)] += 1;
        }
        for(int i = 0 ; i < t.length() ; i++) {
            temp[t.charAt(i)] -= 1;
        }
        for (int i = 0 ; i < temp.length ; i++) {
            if (temp[i] < 0)
                return -1;
        }
        return 1;
    }

    /**
    public String minWindow2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return "";
        }
        String res = "";
        char[] chas1 = s1.toCharArray();
        char[] chas2 = s2.toCharArray();
        int[] map = new int[256];
        for (int i=0; i != chas2.length; i++) {
            map[chas2[i]]++;
        }

        int left = 0;
        int right = 0;
        int match = chas2.length;
        int minLen = Integer.MAX_VALUE;
        while (right != chas1.length) {
            map[chas1[right]]--;
            if (map[chas1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) {
                    map[chas1[left++]]++;
                }
                minLen = Math.min(minLen, right - left +1);
                res = minLen < right-left+1 ? res : s1.substring(left, right);
                match++;
                map[chas1[left++]]++;
            }
        }

        return res;
    }*/

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", target = "ABC";
        MinWindow_76 mw = new MinWindow_76();
        String res = mw.minWindow(s, target);
        System.out.println(res);
    }
}
