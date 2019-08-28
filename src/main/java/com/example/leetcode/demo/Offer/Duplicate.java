package com.example.leetcode.demo.Offer;

import java.util.Arrays;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript 数组中重复的数字
 */
public class Duplicate {

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        byte[] number = new byte[length];

        for (int i=0; i< length; i++) {
            if (number[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                System.out.println(Arrays.toString(duplication));
                return true;
            }
            number[numbers[i]] = 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,4,3,1,4};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers, numbers.length, duplication));
    }
}
