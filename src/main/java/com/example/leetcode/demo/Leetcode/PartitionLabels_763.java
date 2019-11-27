package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 763 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 */
public class PartitionLabels_763 {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] c = S.toCharArray();
        int[] last = new int[26];
        // 存放每个字母最后一次在字符串中出现的位置
        for (int i=0; i<c.length; i++) {
            last[c[i]-'a'] = i;
        }

        int j =0, anchor = 0;
        for (int i=0; i<c.length; i++) {
            j = Math.max(j, last[c[i] - 'a']);
            if (i == j) {
                res.add(i - anchor + 1);
                // 记录下来上一次分组的位置
                anchor = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels(S);
        System.out.println(res);
    }
}
