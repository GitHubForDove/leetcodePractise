package com.example.leetcode.demo.Sort;

import java.util.Arrays;

public class HeapSort {


    public static void headSort(int[] arr) {
        // 开始位置是最后一个叶子节点， 即最后一个节点的父节点
        int start = (arr.length -1)/2;

        // 调整为大顶堆
        for (int i=start; i>=0 ; i--) {
            maxHeap(arr, arr.length, i);
        }

        // 先把数组中第0个和堆中最后一个进行交换，再对前面的处理为大顶堆
        for (int i=arr.length-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    public static void maxHeap(int[] arr, int size, int index) {
        //左子节点
        int leftNode = 2*index + 1;
        // 右子节点
        int rightNode = 2*index + 2;

        int max = index;

        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }

        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }

        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            maxHeap(arr, size, max);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {12,5,2,56,3,23,15,63,42};
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
