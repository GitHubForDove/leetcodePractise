package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 44. 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 */
public class IsMatch_44 {

    /**
     * 通配符匹配
     *   双指针
     */
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        while (i < sn) {
            // 对比 两个字符是否匹配
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') { // 如果遇到 '*' 就将start 设置为当前 ‘*’字符的下标位置 然后 j++ 当前i 下标位置不变
                start = j;
                match = i;
                j++;
            } else if (start != -1) {  // 向后移动i  直到 有一个字符 能跟 ‘*’ 后面的符号匹配的上
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        // 有可能 p 匹配完了 但是 exp 还没有匹配完 判断exp后面的符号是否符合归怎
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }


    /**
     * dp动态规划  解决字符串匹配
     *
     *
     * （一）状态
     *
     *      f[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配
     * （二）转移方程
     *
     *      如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “.”
     *         f[i][j] = f[i - 1][j - 1]
     *      如果s2的第 j 个字符为 *
     *      若s2的第 j 个字符匹配空串, f[i][j] = f[i][j - 1]
     *      若s2的第 j 个字符匹配s1的第 i 个字符, f[i][j] = f[i - 1][j]
     *      这里注意不是 f[i - 1][j - 1]， 举个例子就明白了 (abc, a*) f[3][2] = f[2][2]
     * （三）初始化
     *
     *      f[0][i] = f[0][i - 1] && s2[i] == *
     *      即s1的前0个字符和s2的前i个字符能否匹配
     */

    public boolean isMatch_dp(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }

    /**
     * 递归回溯 解法
     */

    public boolean isMatch_reCur(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch(char[] ss, int i, char[] ps, int j) {
        boolean result = false;
        if (j == ps.length) {
            result = i == ss.length;
        } else {
            boolean firstMath = i != ss.length && (ss[i] == ps[j] || ps[j] == '?');
            if (ps[j] == '*') {
                result = (i != ss.length && isMatch(ss, i+1, ps, j)) || isMatch(ss, i, ps, j+1);
            } else {
                result = firstMath && isMatch(ss, i+1, ps, j+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IsMatch_44 im = new IsMatch_44();
        String s1 = "aaabcd";
        String exp = "a*abcd";
        boolean res = im.isMatch(s1, exp);
        System.out.println(res);
    }

}
