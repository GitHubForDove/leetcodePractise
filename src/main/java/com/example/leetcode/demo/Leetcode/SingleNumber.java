package com.example.leetcode.demo.Leetcode;

public class SingleNumber {


    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int result=0;
        for(int i=0;i<len;i++){
            result ^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
