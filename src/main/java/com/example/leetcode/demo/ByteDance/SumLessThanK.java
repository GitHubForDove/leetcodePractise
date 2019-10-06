package com.example.leetcode.demo.ByteDance;


import java.util.Arrays;
import java.util.Scanner;

/**
a  */
public class SumLessThanK {

    public static int count = 0;

    public static int sumLessThanK(int[] number, int k) {

        if (number == null || number.length < 3) {
            return 0;
        }

        Arrays.sort(number);

        for (int i=0;i < number.length-2; i++) {
            twoSum(number, i+1, k-number[i]);
        }

        return count;
    }


    public static void twoSum(int[] number, int start, int target) {
        if (number == null || number.length < 2) {
            return;
        }

        int l = start;
        int r = number.length -1;
        while (l < r) {
            if (number[l] + number[r] < target) {
                count += r-l;
                l++;
            } else if (number[l] + number[r] >= target) {
                r--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            String str = sc.nextLine();
            str = sc.nextLine();
            String[] arrays = str.split("\\ ");
            for (int i=0; i<len; i++) {
                arr[i] = Integer.valueOf(arrays[i]);
            }

            int k = sc.nextInt();
            int res = sumLessThanK(arr, k);
            System.out.println(res);
        }
    }
}
