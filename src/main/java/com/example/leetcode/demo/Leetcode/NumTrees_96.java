package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class NumTrees_96 {

    /**
     * dp动态规划
     *
     *  思路：
     *      F(i,n)=G(i−1)⋅G(n−i)(2)
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<dp.length; i++) {
            for (int j=1; j<i+1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     * 按照卡特兰数公式
     * C0 = 1， Cn+1 = (2(2n+1)/(n+2))* Cn
     */
    public int numTrees2(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public static void main(String[] args) {
        NumTrees_96 nt = new NumTrees_96();
        int res = nt.numTrees2(3);
        System.out.println(res);
    }

}
