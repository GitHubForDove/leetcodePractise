package com.example.leetcode.demo.Leetcode;


/**
 * leetcode
 * 713. 乘积小于K的子数组
 * <p>
 * 给定一个正整数数组 nums。
 * <p>
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 * <p>
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 */
public class NumSubarrayProductLessThanK_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isPass(nums, i, j, k)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPass(int[] nums, int i, int j, int k) {
        int sum = 1;
        for (int n = i; n <= j; n++) {
            sum *= nums[n];
            if (sum >= k) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }
        int l = 0, sum = 0, res = 1;
        for (int r = 0; r < nums.length; r++) {
            res *= nums[r];
            while (res >= k) {
                res /= nums[l];
                l++;
            }
            sum += (r - l + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        NumSubarrayProductLessThanK_713 msplt = new NumSubarrayProductLessThanK_713();
        int res = msplt.numSubarrayProductLessThanK2(nums, 100);
        System.out.println(res);
    }
}
