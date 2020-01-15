package com.example.leetcode.demo.Leetcode;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-nums[i-1] == 1) {
                dp[i] = dp[i-1] + 1;
            } else if(nums[i] == nums[i-1]){
                dp[i] = dp[i-1];
            } else {
                if (max < dp[i-1]) {
                    max = dp[i-1];
                }
            }
        }

        return max;
    }

    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //n - 1 是否存在
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        LongestConsecutive_128 lc = new LongestConsecutive_128();
        int res = lc.longestConsecutive(nums);
        System.out.println(res);
    }
}
