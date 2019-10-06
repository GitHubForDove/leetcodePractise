package com.example.leetcode.demo.pdd;

import java.util.*;

public class Question_2 {


    public static long maxK(int n, int m, int k) {

        long max = 1;

        /*PriorityQueue<Long> maxHeap = new PriorityQueue<Long>();
*/
        int[] num1 = new int[n];
        int[] num2 = new int[m];
        for (int i= 0 ; i<n ;i++) {
            num1[i] = i+1;
        }

        for (int j= 0 ; j<m ;j++) {
            num2[j] = j+1;
        }

        int tempN = n-1;
        int tempM = m-1;
        boolean flag = true;
        for (int i = 0; i < k; i++) {

            max = num1[tempN] * num2[tempM];

            if ((tempN-1>= 0) &&  (num1[ -1] - num2[tempM])>0) {
                tempN--;
            } else {
                tempM --;
            }

        }

        return max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numbers = sc.nextLine();
            String[] number = numbers.split(" ");
            int n = Integer.valueOf(number[0]);
            int m = Integer.valueOf(number[1]);
            int k = Integer.valueOf(number[2]);
            long max = maxK(n,m,k);
            System.out.println(max);
        }
    }
}
