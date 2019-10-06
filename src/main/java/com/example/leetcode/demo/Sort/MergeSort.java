package com.example.leetcode.demo.Sort;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     */

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high)/2;
        if (low < high) {
            // 处理左边
            mergeSort(arr, low, mid);
            // 处理右边
            mergeSort(arr,mid+1, high);
            // 将数组进行排序
            merge(arr, low, mid, high);
        }

    }

    // 排序
    public static void merge(int[] arr, int low, int mid, int high) {

        // 用于存储排序后的数组
        int[] temp = new int[high - low + 1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        int j = mid + 1;
        //用户存放临时数组中的下标
        int index = 0;


        while (i <= mid && j <= high) {

            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            }else {
                temp[index++] = arr[j];
                j++;
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i];
            i++;
        }

        while (j <= high) {
            temp[index++] = arr[j];
            j++;
        }


        // 把临时数组重新赋值给arr数组
        for (int k=0; k < temp.length; k++) {
            // 需要加上low开始的地方
            arr[k+low] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,6,1,46,3,43,5,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
