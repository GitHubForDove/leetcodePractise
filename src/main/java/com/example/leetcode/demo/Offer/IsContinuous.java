package com.example.leetcode.demo.Offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class IsContinuous {

    /**
     * 题目：从扑克牌中随机抽取5张牌，判断是不是一个顺子，既用着5张牌是不是连续的。
     * 2-10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
     */

    public static boolean isContinuous(int[] numbers) {

        if (numbers == null || numbers.length < 1) {
            return false;
        }

        Arrays.sort(numbers);

        int numOfZero = 0;
        int numOfGap = 0;

        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
            }
        }

        int small = numOfZero;
        int big = small + 1;

        while (big < numbers.length) {

            if (numbers[small] == numbers[big]) {
                return false;
            }
            // 计算两个数之间的Gap值
            numOfGap += numbers[big] - numbers[small]-1;

            small = big;
            big++;
        }

        return numOfGap <= numOfZero;

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0,1,3,4,5};
        System.out.println(isContinuous(numbers));
    }
}
