package com.example.leetcode.demo.ByteDance;

import java.util.Scanner;

public class Dp {


    public static int dp(int[] valOld, int[] valNew,  int[] wt, int W ) {
        int N = wt.length;

        int[][] V = new int[N+1][W+1];

        for (int i=0; i<= W; i++) {
            V[0][i] = 0;
        }

        for (int j=0; j<= N; j++) {
            V[j][0] = 0;
        }

        for (int i=1; i<= N; i++) {

            for (int j =1; j<=W; j++) {

                if (wt[i-1] <= j) {
                    V[i][j] = Math.max(valNew[i-1] + V[i-1][j-wt[i-1]],V[i-1][j]);
                } else {
                    V[i][j] = V[i-1][j];
                }
            }
        }

        return V[N][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] arr = str.split("\\ ");
            int n = Integer.valueOf(arr[0]);
            int w = Integer.valueOf(arr[1]);
            int[] valOld = new int[n];
            int[] valNew = new int[n];
            int[] weight = new int[n];
            for (int i=0; i<n; i++) {
                String temp = sc.nextLine();
                String[] tempArr = temp.split("\\ ");
                int val1 = Integer.valueOf(tempArr[0]);
                valOld[i] = val1;
                int val2 = Integer.valueOf(tempArr[1]);
                valNew[i] = val2;
                int wi = Integer.valueOf(tempArr[2]);
                weight[i] = wi;
            }

            int res = dp(valOld, valNew, weight, w);
            System.out.println(res);

        }
    }
}
