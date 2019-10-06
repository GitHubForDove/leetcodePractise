package com.example.leetcode.demo.sougou;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {


    public static int fuc(int M, int N, ArrayList<ArrayList<Integer>> list) {
        int[] arr = new int[M];
        for (int i=0; i<N; i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);
            for (int j = start; j<end;j++) {
                arr[j] = i;
            }
        }
        int res = 0;
        for (int i=0; i<arr.length; i++) {
            res += arr[i] * i;
        }

        return res % 100000009;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            str = sc.nextLine();

            String[] arr = str.split("\\ ");
            int N = Integer.valueOf(arr[0]);
            int M = Integer.valueOf(arr[1]);

            for (int i=0; i<M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
            }
        }
    }
}
