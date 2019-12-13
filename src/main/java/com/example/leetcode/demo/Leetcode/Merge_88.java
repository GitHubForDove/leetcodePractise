package com.example.leetcode.demo.Leetcode;

import java.util.Arrays;

/**
 * leetcode 88
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class Merge_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i=0; i<m; i++) {
            temp[i] = nums1[i];
        }
        int i=0,j=0,index = 0;
        while (i<m && j<n) {
            if (temp[i] <= nums2[j]) {
                nums1[index++] = temp[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
        if (i < m) {
            for (int k = i; k<m; k++) {
                nums1[index++] = temp[k];
            }
        }

        if (j < n) {
            for (int k = j; k<n; k++) {
                nums1[index++] = nums2[k];
            }
        }
    }

    /**
     * 思路：
     *   从后往前将大的数填入到新建的数组中，选中的数组下标递减。
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,0};
        int[] nums2 = new int[]{6};
        merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
