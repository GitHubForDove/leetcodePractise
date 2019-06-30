package com.example.leetcode.demo.DynamicProgramming;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-19
 * @descript 爬楼梯  斐波那契数列
 */
public class ClimbingStairs_NO_70 {


    public static void main(String[] args) {

        int n = 3;
        int res = climbStairs(n);
        System.out.println(res);
    }


    // 爬房子
    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // dp[i] = dp[i-1] + dp[i-2]
        for (int i=3; i<= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
