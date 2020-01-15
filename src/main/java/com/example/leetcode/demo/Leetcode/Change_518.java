package com.example.leetcode.demo.Leetcode;


/**
 * 518. 零钱兑换 II
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 */
public class Change_518 {


    /**
     * 动态规划 dp
     */
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        // 设置起始状态
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     * dfs 超时
     */
    public int change2(int amount, int[] coins) {
        //helper(amount, coins, 0);
        return helper(amount, coins, 0);
    }

    private int helper(int amount, int[] coins, int index) {
        int res = 0;
        if (index == coins.length) {
            res = amount == 0 ? 1 : 0;
        } else {
            for (int i=0; coins[index] * i <= amount ; i++) {

                res += helper(amount-i*coins[index], coins, index+1);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] coins  = new int[]{1, 2, 5};
        Change_518 c = new Change_518();
        int res = c.change2(5, coins);
        System.out.println(res);
    }
}
