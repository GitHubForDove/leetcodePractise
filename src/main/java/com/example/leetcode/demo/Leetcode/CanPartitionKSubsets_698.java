package com.example.leetcode.demo.Leetcode;


import java.util.Arrays;

/**
 * leetcode  698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 * 注意:
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class CanPartitionKSubsets_698 {


    /**
     * 使用 dfs 深搜解决 所有的匹配问题
     */

    int[] bucket;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        bucket = new int[k];
        Arrays.fill(bucket, sum/k);

        return dfs(k, nums, nums.length - 1);
    }

    private boolean dfs(int k, int[] nums, int cur) {
        // 终止条件 当cur 小于0时 说明已经走过了开头的位置  说明满足条件
        if (cur < 0) {
            return true;
        }

        for (int i = 0; i < k; i++) {

            if (bucket[i] == nums[cur] || bucket[i] - nums[cur] >= nums[0]) {
                bucket[i] -= nums[cur];
                if (dfs(k, nums, cur - 1)) {
                    return true;
                }
                bucket[i] += nums[cur];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 3, 4, 5};
        CanPartitionKSubsets_698 cpk = new CanPartitionKSubsets_698();
        boolean res = cpk.canPartitionKSubsets(nums, 4);
        System.out.println(res);
    }
}
