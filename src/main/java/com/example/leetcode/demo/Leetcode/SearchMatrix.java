package com.example.leetcode.demo.Leetcode;

public class SearchMatrix {


    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;
        while (i < row && j>= 0) {

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};*/
        int[][] matrix = new int[][]{{-5}};
        System.out.println(searchMatrix(matrix, -5));
    }
}
