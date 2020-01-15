package com.example.leetcode.demo.Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 */
public class FindLHS_594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0, sum = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                sum = map.get(key) + map.get(key + 1);
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        FindLHS_594 f = new FindLHS_594();
        int res = f.findLHS(nums);
        System.out.println(res);
    }
}
