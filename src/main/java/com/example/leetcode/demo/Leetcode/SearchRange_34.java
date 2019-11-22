package com.example.leetcode.demo.Leetcode;


import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange_34 {


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 ) {
            return new int[]{-1,-1};
        }

        if (nums[0] == nums[nums.length-1] && nums[0] == target) {
            return new int[]{0,nums.length-1};
        }

        int leftIndex = binarySearchLeftIndex(nums, target);
        int rightIndex = binarySearchRightIndex(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    public static int binarySearchLeftIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right)>>1;
            if (nums[mid] == target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }

    public static int binarySearchRightIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right)>>1;
            if (nums[mid] == target) {
                left = mid+1;
            }else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int[] range = searchRange(nums, 3);
        int res = binarySearchRightIndex(nums, 6);
        System.out.println(Arrays.toString(range));
        System.out.println(res);
    }
}
