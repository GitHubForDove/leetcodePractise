package com.example.leetcode.demo.ByteDance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxNumber {


    public static int maxNumber(int[] number) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i=number.length-1; i>=0; i--) {
            deque.add(number[i]);
        }
        int start = 0;
        int end = number.length-1;
        int max = 0;
        int count = 1;
        while (!deque.isEmpty()) {

            if (count % 2 !=0) {
                if (deque.getLast() < deque.peek()) {
                    max += deque.pollFirst();
                    count++;
                } else {
                    max += deque.pollLast();
                    count++;
                }

            } else {
                if (deque.getLast() < deque.peek()) {
                    deque.pollFirst();
                    count++;
                } else {
                    deque.pollLast();
                    count++;
                }
            }

        }

        return max;
    }


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.nextLine();
            str = sc.nextLine();
            String[] arr = str.split("\\ ");
            int[] num = new int[arr.length];
            for (int i=0; i<num.length; i++) {
                num[i] = Integer.valueOf(arr[i]);
            }
            int res = maxNumber(num);
            System.out.println(res);
        }
    }
}
