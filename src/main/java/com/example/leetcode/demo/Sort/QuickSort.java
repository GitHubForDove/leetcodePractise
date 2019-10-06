package com.example.leetcode.demo.Sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序
     */


    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {

            int low = start;
            int hight = end;
            // 把标准值 拿出来
            int stard = arr[low];
            while (low < hight) {

                while (stard <= arr[hight] && low < hight) {
                    hight--;
                }

                arr[low] = arr[hight];

                while (stard >= arr[hight] && low < hight) {
                    low ++;
                }
                arr[hight] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {12,5,2,56,3,23,15,63,42};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
