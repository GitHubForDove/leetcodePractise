package com.example.leetcode.demo.DynamicProgramming;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-20
 * @descript leetcode 64 最小路径和
 */
public class MinPathSum_No_64 {


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}};

        int result = minPathSum(grid);

        System.out.println(result);

    }


    // 求解最小路径和
    public static int minPathSum(int[][] grid) {

        if (grid.length == 0) return 0;

        int[][] dp = new int[grid.length][ grid[0].length];

        // 赋值给第一个位置的值
        dp[0][0] = grid[0][0];
        // 初始化 向左的第一行数值
        for (int i=1;i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 初始化 向下的第一行数值
        for (int j=1;j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        // 双重循环 比较路径的值
        for (int i=1; i < grid.length;i++) {
            for (int j=1; j < grid[0].length; j++) {
                // 找出最小值
                dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
