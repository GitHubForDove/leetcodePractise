package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode 131. 分割回文串
 *
 *  给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition_131 {

    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return lists;
        List<String> list = new ArrayList<>();
        dfs(s, list, 0);

        return lists;
    }

    public void dfs(String s, List<String> list,  int index) {
        if (index == s.length()) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i=index; i<s.length(); i++) {
            if (isPalindronme(s.substring(index, i+1))) {
                list.add(s.substring(index, i+1));
                dfs(s, list,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindronme(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        int i=0;
        int j=s.length()-1;
        while (i <= j && j>=0 && i< s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        Partition_131 p = new Partition_131();
        List<List<String>> res = p.partition(s);
        System.out.println(res);
    }
}
