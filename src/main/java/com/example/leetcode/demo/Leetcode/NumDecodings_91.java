package com.example.leetcode.demo.Leetcode;


import java.util.HashMap;

/**
 *
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NumDecodings_91 {

    /**
     * 思路：
     *
     * 很容易想到递归去解决，将大问题化作小问题。
     *
     * 比如 232232323232。
     *
     * 对于第一个字母我们有两种划分方式。
     *
     * 2|32232323232 和 23|2232323232
     *
     * 所以，如果我们分别知道了上边划分的右半部分 32232323232 的解码方式是 ans1 种，2232323232 的解码方式是 ans2 种，
     * 那么整体 232232323232 的解码方式就是 ans1 + ans2 种。可能一下子，有些反应不过来，可以看一下下边的类比。
     *
     * 假如从深圳到北京可以经过武汉和上海两条路，而从武汉到北京有 8 条路，从上海到北京有 6 条路。
     * 那么从深圳到北京就有 8 + 6 = 14 条路。
     *
     * 类似于 跳楼梯的思想
     */

    public int numDecodings_bw(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return func(s, 0);
    }

    private int func(String s, int start) {
        // 递归第一步 加终止条件
        if (s.length() == start) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        //递归的递推式应该是如果index的后两位小于等于26，
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = func(s, start+1);
        int ans2 = 0;
        if (start < s.length()-1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = func(s, start + 2);
            }
        }

        return ans1 + ans2;
    }


    public int numDecodings_bw2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return func(s, 0, map);
    }

    private int func(String s, int start, HashMap<Integer, Integer> map) {
        // 递归第一步 加终止条件
        if (s.length() == start) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int m = map.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }

        //递归的递推式应该是如果index的后两位小于等于26，
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = func(s, start+1);
        int ans2 = 0;
        if (start < s.length()-1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = func(s, start + 2);
            }
        }
        map.put(start, ans1 + ans2);
        return ans1 + ans2;
    }


    /**
     * 从后往前动态规划
     *
     * 同样的，递归就是压栈压栈压栈，出栈出栈出栈的过程，我们可以利用动态规划的思想，
     * 省略压栈的过程，直接从 bottom 到 top。
     *
     * 用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，
     * 也就是 s 从 i 开始到结尾的字符串的解码方式。
     *
     * 这样和递归完全一样的递推式。
     *
     * 如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
     *
     * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
     *
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
