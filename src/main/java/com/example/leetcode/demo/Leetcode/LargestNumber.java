package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 一个数组数组,请组合成一个最大的数字字符串
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        int n;
        StringBuilder s= new StringBuilder();
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=nums.length;
        for(int i=0;i<n;i++){
            list.add(nums[i]);

        }
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });

        for(int j:list){
            s.append(j);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,34,35,5,9};
        String res = largestNumber(nums);
        System.out.println(res);
    }
}