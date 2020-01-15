package com.example.leetcode.demo.Leetcode;


import java.util.HashMap;
import java.util.Map;

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

    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        //遍历字符串 t，初始化每个字母的次数
        for (int i = 0; i < t.length(); i++) {
            char char_i = t.charAt(i);
            map.put(char_i, map.getOrDefault(char_i, 0) + 1);
        }
        int left = 0; //左指针
        int right = 0; //右指针
        int ans_left = 0; //保存最小窗口的左边界
        int ans_right = -1; //保存最小窗口的右边界
        int ans_len = Integer.MAX_VALUE; //当前最小窗口的长度
        //遍历字符串 s
        while (right < s.length()) {
            char char_right = s.charAt(right);
            //判断 map 中是否含有当前字母
            if (map.containsKey(char_right)) {
                //当前的字母次数减一
                map.put(char_right, map.get(char_right) - 1);
                //开始移动左指针，减小窗口
                while (match(map)) { //如果当前窗口包含所有字母，就进入循环
                    //当前窗口大小
                    int temp_len = right - left + 1;
                    //如果当前窗口更小，则更新相应变量
                    if (temp_len < ans_len) {
                        ans_left = left;
                        ans_right = right;
                        ans_len = temp_len;
                    }
                    //得到左指针的字母
                    char key = s.charAt(left);
                    //判断 map 中是否有当前字母
                    if (map.containsKey(key)) {
                        //因为要把当前字母移除，所有相应次数要加 1
                        map.put(key, map.get(key) + 1);
                    }
                    left++; //左指针右移
                }
            }
            //右指针右移扩大窗口
            right++;
        }
        return s.substring(ans_left, ans_right+1);
    }

    //判断所有的 value 是否为 0
    private boolean match(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
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
        String res = mw.minWindow2(s, target);
        System.out.println(res);
    }
}
