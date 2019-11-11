package com.example.leetcode.demo.Leetcode;


import java.util.Scanner;

/**
 *
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump_55 {


    public static boolean canJump(int[] nums) {

        if (nums == null) {
            return false;
        }
        int pos = nums.length-1;

        // 倒着推回去 判断下一个i位置  能不能走到当前的index
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }
        }

        return pos == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i=0; i<n; i++) {
                nums[i] = sc.nextInt();
            }
            boolean res = canJump(nums);
            System.out.println(res);
        }
    }
}
