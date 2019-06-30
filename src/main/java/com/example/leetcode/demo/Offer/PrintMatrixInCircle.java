package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-29
 * @descript 顺时针打印数组
 */
public class PrintMatrixInCircle {


    public static void main(String[] args) {
        int[][] numbers = new int[][]{
                {1,2,3,4},
                {4,5,6,5},
                {7,8,9,6}
        };

        printMatrixInCircleWisely(numbers);
    }

    public static void printMatrixInCircleWisely(int[][] numbers) {

        if (numbers == null && numbers.length == 0) {
            return;
        }

        int start = 0;
        int rows = numbers.length;
        int columns = numbers[0].length;

        while (columns > start * 2 && rows > start * 2) {

            printMatrixInCircle(numbers, columns, rows, start);
            ++start;
        }
    }


    public static void  printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {

        // colums: x 轴的最大数
        // rows： y轴的最大数
        int endX = columns - 1 -start;
        int endY = rows -1 - start;



            // 从左向右打印
            for (int i=start; i<= endX; i++) {
                System.out.print(numbers[start][i]);
            }

            System.out.println();
            // 从上往下打印  临界值 start < endY
            if (start < endY) {

                for (int i = start+1; i<= endY ;i++) {
                    System.out.print(numbers[i][endX]);
                }
            }

            System.out.println();
            // 从右向左打印
            if (start < endX && start < endY) {

                for (int i=endX-1; i >= start; i--) {
                    System.out.print(numbers[endY][i]);
                }
            }

            System.out.println();
            // 从下往上打印
            if (start < endX && start<endY-1) {
                for (int i=endY-1; i >= start +1; i--) {
                    System.out.print(numbers[i][start]);
                }
            }

    }

}
