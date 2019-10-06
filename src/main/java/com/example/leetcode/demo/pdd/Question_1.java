package com.example.leetcode.demo.pdd;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 拼多多 后端测试  第一题
 */
public class Question_1 {

    public static int[] priorityN(int[] arr, int N) {

        if (N == 0) {
            return null;
        }

        Arrays.sort(arr);
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        int[] res = new int[N];
        for (int i= arr.length-1; i > 0; i--) {
            if (arr[i] % 2 == 0) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }

        if (list1.size() < N) {

            for (int i=0; i<list1.size(); i++) {
                res[i] = list1.get(i);
            }

            for (int j = 0; j < N-list1.size(); j++) {
                res[j + list1.size()] = list2.get(j);
            }
        } else {

            for (int i=0; i< N; i++) {
                res[i] = list1.get(i);
            }
        }


        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numbers = sc.nextLine();
            String[] arrs = numbers.split("\\;");
            String[] arrStr = arrs[0].split("\\,");
            int N = Integer.valueOf(arrs[1]);
            int[] arr = new int[arrStr.length];
            for (int i=0; i<arrStr.length; i++) {
                arr[i] = Integer.valueOf(arrStr[i]);
            }

            int[] res = priorityN(arr, N);
            for (int i=0;i<res.length; i++) {
                System.out.print(res[i]);
                if (i != res.length-1) {
                    System.out.print(",");
                }
            }
        }
    }
}
