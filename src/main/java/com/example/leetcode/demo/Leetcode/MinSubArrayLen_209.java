package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen_209 {

    /**
     * 双指针
     */
    public static int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int len = nums.length;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 双指针 滑动窗口
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int len = nums.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < len) {

            if (sum + nums[right] < s) {
                sum += nums[right];
                right++;
            }else {
                if (right-left < minLen) {
                    minLen = right - left + 1;
                }

                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(7, nums);
        System.out.println(res);
    }
}
