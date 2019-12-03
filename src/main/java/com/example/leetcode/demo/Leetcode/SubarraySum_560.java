package com.example.leetcode.demo.Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * leetode 560. 和为K的子数组
 * <p>
 * 给定一个整数和一个整数k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySum_560 {

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>(len * 2);
        // 使用前缀和 记录前面累加的结果
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int sub = sum[i] - k;
            res += map.getOrDefault(sub, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        int res = subarraySum(nums, 1);
        System.out.println(res);
    }
}
