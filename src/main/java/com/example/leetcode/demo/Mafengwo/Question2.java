package com.example.leetcode.demo.Mafengwo;

import java.util.Scanner;

public class Question2 {


    public static int numSubarrayProductLessThanK(int[] arr, int threshold ) {
        if (threshold <= 1) {
            return 0;
        }

        int n=0;
        int i=0;
        int mul = 1;

        for (int j=0; j<arr.length; j++) {
            mul *= arr[j];
            while (mul >= threshold) {
                mul /= arr[i];
                i++;
            }
            n += (j-i+1);
        }

        return n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            //str = sc.nextLine();
            String[] strArr = str.split(",");
            int[] arr = new int[strArr.length];
            for (int i=0; i<arr.length; i++) {
                arr[i] = Integer.valueOf(strArr[i]);
            }
            String n = sc.next();
            int threshold = Integer.valueOf(n);
            System.out.println(numSubarrayProductLessThanK(arr, threshold));
        }
    }
}
