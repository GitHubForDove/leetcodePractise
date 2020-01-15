package com.example.leetcode.demo.Leetcode;


/**
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome_409 {

    /**
     * 题解：
     * https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode/
     *
     */
    public int longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        char[] chas = s.toCharArray();
        int[] count = new int[128];
        for (int i = 0; i < chas.length; i++) {
            count[chas[i]]++;
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            //当count中的元素是大于等于2个时，result等于其小于count[i]的最大的偶数
            result += count[i] / 2 * 2;
            //当count[i]为奇数时，且result的数量为偶数时，这个数可以放在中间组成回文的middle
            if (count[i] % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
