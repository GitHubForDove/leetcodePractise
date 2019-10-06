package com.example.leetcode.demo.Offer;


/**
 * 给定一个无序数组，求数组中长度最大的递增子序列
 */
public class lengthOfLIS {

    /**
     * 思路：使用dp的思想，前面的结果 与后面的结果有关联，前面的结果会对后面的结果产生影响
     */
    public static int lengthOfList(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        for (int i=0; i< dp.length; i++) {
            dp[i] = 1;
            for (int j = i+1; j >= 0; j--) {

                if (nums[j] < nums[i]) {
                    dp[j] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     *

    public static int lengthOfListNoContinue(int[] nums) {

    }
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,5,1,7,8};
        int res = lengthOfList(arr);
        System.out.println(res);
    }
}
