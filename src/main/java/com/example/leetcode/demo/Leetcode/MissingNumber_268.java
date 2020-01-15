package com.example.leetcode.demo.Leetcode;


/**
 * 268. 缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber_268 {

    /**
     * 使用异或 解决
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i=0; i<nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }

        return res;
    }

    /**
     * 等差数列
     */
    public int missingNumber2(int[] nums) {
        //实际当前数列的和
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        //完整数列的和
        int realSum = (len * (len + 1)) / 2;
        return realSum - sum;
    }
}
