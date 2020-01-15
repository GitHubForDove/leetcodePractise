package com.example.leetcode.demo.Leetcode.weeklyContest.number171;

import javax.crypto.interfaces.PBEKey;
import java.util.Arrays;

/**
 * 5307. 将整数转换为两个无零整数的和
 *
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 *
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 *
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 *
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 */
public class GetNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        int i=1, j = n-1;
        while (i<=n && j>=1 && i<= j) {
            if (i+j == n && !isContainZero(i) && !isContainZero(j)) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (i+j <= n) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public boolean isContainZero(int n) {
        String s = String.valueOf(n);
        if (s.contains("0")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GetNoZeroIntegers gnzi = new GetNoZeroIntegers();
        int[] res = gnzi.getNoZeroIntegers(20000);
        System.out.println(Arrays.toString(res));
    }
}
