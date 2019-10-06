package com.example.leetcode.demo.Offer;


import java.util.ArrayList;

/**
 * 和为s的两个数字
 */
public class FindNumbersWithSum {

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     */

    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length == 0) {
            return res;
        }

        int start = 0;
        int end = array.length-1;
        int temp = Integer.MAX_VALUE;
        while (start <= end) {
            int sumTemp = array[start] + array[end];
            if (sumTemp == sum) {
                int mulRes = array[start] * array[end];
                if (temp > mulRes) {
                    res.clear();
                    res.add(0,array[start]);
                    res.add(1,array[end]);
                    temp = mulRes;
                }
                start++;

            } else if (sumTemp < sum) {
                start++;
            } else {
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-3,-2,-1,1,2,3,4,5,6};
        ArrayList<Integer> res = findNumbersWithSum(array, 1);
        System.out.println(res);
    }
}
