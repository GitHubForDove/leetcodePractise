package com.example.leetcode.demo.Leetcode;


/**
 * 48 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 */
public class Rotate_48 {

    public static void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[row-i-1];
            matrix[row-i-1] = temp;
        }

        for (int i=0; i<row; i++) {
            for (int j=i; j<col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }



    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
