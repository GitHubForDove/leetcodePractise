package com.example.leetcode.demo.Offer;

public class FindGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray(int[] array) {


        // 初级动态规划
        int max = array[0];
        int res = array[0];
        for (int i=1; i<array.length; i++) {
            max = Math.max(array[i], max+array[i]);
            res = Math.max(max, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(array));
    }
}
