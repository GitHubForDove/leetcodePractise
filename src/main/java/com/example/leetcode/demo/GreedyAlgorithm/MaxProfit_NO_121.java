package com.example.leetcode.demo.GreedyAlgorithm;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-21
 * @descript 买卖股票最大的收益
 *             题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *
 *             只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，
 *
 *             查看当前收益是不是最大收益。
 */
public class MaxProfit_NO_121 {


    public static void main(String[] args) {
        int[] prices = new int[]{2,5,3,8,4,1};
        int res = maxProfit(prices);
        System.out.println(res);
    }


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n ==0 ) return 0;

        int soMin = prices[0];
        int maxProfit = 0;

        for (int i=1 ; i<n ;i++) {
            if (soMin > prices[i]) {
                soMin = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - soMin);
            }
        }

        return maxProfit;
    }



}
