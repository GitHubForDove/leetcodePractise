package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 机器人的运动范围
 */
public class movingCount {


    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */

/*    public static int movingCount(int threshold, int rows, int cols) {

        int res = 0;
        if (rows == 0 && cols == 0) {
            return 0;
        }

        if (rows == 1 || cols == 1) {
            int num = rows == 1 ? cols : rows;
            for (int j = 0; j < num; j++) {
                if ((1 + numSum(j)) <= threshold) {
                    System.out.println(j);
                    ++res;
                }
            }
        } else {

            for (int i = 0;i < rows-1; i++) {

                for (int j = 0; j < cols; j++) {
                    if ((numSum(i) + numSum(j)) <= threshold) {
                        ++res;
                    }
                }
            }
        }


        return res;
    }*/

    public static int numSum(int num) {
        int sum = 0;

        while (num !=0 ) {
            sum += num/10 != 0 ?  num%10 :  num;
            num = num/10;
        }


        return sum;
    }


    public static int movingCount2(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private static int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    public static int count = 0;
    public static int movingCount_resolve_DFS(int threshold, int rows, int cols)
    {
        boolean[] pass = new boolean[rows*cols];
        movingCount_resolve_DFS(threshold,0,0,rows,cols,pass);
        return count;
    }

    public static void movingCount_resolve_DFS(int threshold, int i, int j,int rows, int cols,boolean[] pass){
        int index = i*cols + j;

        // 如果不满足边界条件
        if(i<0||j<0||i>=rows||j>=cols|| pass[index]){
            return;
        }

        if ((numSum(i) + numSum(j)) <= threshold) {
            count++;
            pass[index] = true;
        } else {
            pass[index] = false;
            return;
        }
        // 向左走
        movingCount_resolve_DFS(threshold, i-1,j,rows,cols,pass);
        // 向右走
        movingCount_resolve_DFS(threshold, i+1,j,rows,cols,pass);
        // 向上走
        movingCount_resolve_DFS(threshold, i,j-1,rows,cols,pass);
        // 向下走
        movingCount_resolve_DFS(threshold, i,j+1,rows,cols,pass);

    }


    public static void main(String[] args) {
        //System.out.println(numSum(123));
        System.out.println(movingCount2(3, 3,6));
        System.out.println(movingCount_resolve_DFS(10, 1,100));
    }
}
