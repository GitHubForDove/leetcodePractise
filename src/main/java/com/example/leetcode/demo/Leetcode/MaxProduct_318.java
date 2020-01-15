package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 318. 最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 */
public class MaxProduct_318 {

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }

        int len = 0;
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (!isContain(words[i], words[j])) {
                    len = Math.max(len, words[i].length() * words[j].length());
                }
            }
        }
        return len;
    }

    private boolean isContain(String word, String word1) {

        for (int i=0; i<word.length(); i++) {
            String c = String.valueOf(word.charAt(i));
            if (word1.contains(c)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        MaxProduct_318 mp = new MaxProduct_318();
        int res = mp.maxProduct(words);
        System.out.println(res);
    }
}
