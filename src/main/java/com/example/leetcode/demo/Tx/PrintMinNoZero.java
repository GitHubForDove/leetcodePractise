package com.example.leetcode.demo.Tx;

import java.util.Arrays;
import java.util.Scanner;

public class PrintMinNoZero {


    public static void print(int[] nums, int k, int index) {

        if (k <= 0 || index >= nums.length-1) {
            return;
        }

        while ( k > 0 || index < nums.length) {
            if (nums[0] == 0 &&  nums[nums.length-1] == 0) {
                while (k > 0) {
                    System.out.println(0);
                    k--;
                }
                return;
            }

            int min = 0;
            for (int i= index; i< nums.length; i++) {
                if (nums[i] != 0) {
                    System.out.println(nums[i]);
                    min = nums[i];
                    break;
                }
            }

            for (int i = index; i< nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = nums[i] - min;
                }
            }
        }

        /*if (nums[0] == 0 &&  nums[nums.length-1] == 0) {
            while (k > 0) {
                System.out.println(0);
                k--;
            }
            return;
        }

        int min = 0;
        for (int i= index; i< nums.length; i++) {
            if (nums[i] != 0) {
                System.out.println(nums[i]);
                min = nums[i];
                break;
            }
        }

        for (int i = index; i< nums.length; i++) {
            if (nums[i] != 0) {
               nums[i] = nums[i] - min;
            }
        }
        k = k-1;
        index = index + 1;
        if (index >= nums.length-1) {
            return;
        }
        print(nums, k, index);*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n;i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            print(arr, k, 0);
        }
    }
}
