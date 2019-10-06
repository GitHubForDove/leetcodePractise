package com.example.leetcode.demo.Offer;

import java.util.ArrayList;

public class PrintMatrix {


    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 0 || col == 0) {
            return res;
        }

        int top = 0, left = 0, right = col-1, bottom = row-1;

        while (top <= bottom && left <= right) {

            for (int i=left; i<= right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top+1;i<=bottom; i++) {
                res.add(matrix[i][right]);
            }

            //
            for (int i=right-1; i>=left && top < bottom ;i--) {
                res.add(matrix[bottom][i]);
            }

            // 这里要对top的边界 和 right 和 left的边界做处理
            for (int i=bottom-1;i>top && right > left; i-- ) {
                res.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;

    }


    public static void main(String[] args) {
        int[][] num = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res = printMatrix(num);
        System.out.println(res);
    }
}
