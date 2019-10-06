package com.example.leetcode.demo.VMWARE;

import java.util.Scanner;

public class Question2 {


    /**
     * 桌子上从左到右摆放着N张卡片，第i张卡片上写有数字Ai，两名玩家轮流取走卡片，
     * 每次只能取走最左边或最右边的一张卡片，直到所有卡片都被取走，玩家的分数即为其取走的卡片上的数字之和。
     * 两名玩家都希望自己的分数尽可能高，那么在双方都足够聪明的情况下，先手的分数是多少？
     *
     */


    public static int dp(int[] v) {
        int[][] dp = new int[v.length][v.length];
        int[] sum = new int[v.length];

        for (int i=0; i<v.length; i++) {
            dp[i][i] = v[i];
        }

        for (int i = 1; i < v.length; i++)
            for (int j = 0; i + j < v.length; j++)
                dp[j][i + j] = Math.max(sum[i + j] - sum[j] + v[j] - dp[j + 1][i + j], sum[i + j] - sum[j] + v[j] - dp[j][i + j - 1]);


        return dp[0][v.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i=0; i<v.length;i++) {
                v[i] = sc.nextInt();
            }

            int res = dp(v);
            System.out.println(res);
        }
    }

}
