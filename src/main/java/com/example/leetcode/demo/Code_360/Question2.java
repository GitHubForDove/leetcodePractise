package com.example.leetcode.demo.Code_360;

import java.util.Scanner;

public class Question2 {



    public static double solution(int[] arr, int m) {

        double res = Double.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i< arr.length; i++)
        {
            if (i<m)
                sum += arr[i];
            else
            {
                res = Math.max(sum, res);
                sum += (double) arr[i] - (double) arr[i - m];
            }
        }
        res = Math.max(sum, res);
        return res / (double) m;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }

            double res = solution(arr, 6);
            System.out.println(String.format("%.3f", res));
        }

       // int[] arr = new int[]{6,4,2,10,3,8,5,9,4,1};

    }
}
