package com.example.leetcode.demo.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. 网格中的最短路径
 *
 * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 *
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径
 * ，则返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *  
 *
 * 示例 2：
 *
 * 输入：
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * 输出：-1
 * 解释：
 * 我们至少需要消除两个障碍才能找到这样的路径。
 *
 */
public class ShortestPath_1293 {
    int count;
    public int shortestPath(int[][] grid, int k) {

        if (grid == null || grid.length == 0 || grid[0].length == 0
                || (grid[0][0] != 0 && k>=1) || (grid[grid.length-1][grid[0].length-1] != 0 && k >= 1)) {
            return -1;
        }

        int[][] map = new int[grid.length][grid[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        count = k;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();

            if (r == grid.length-1 && c == grid[0].length-1) {
                return map[r][c];
            }

            walkTo(map[r][c], grid, map, r-1, c, rQ, cQ);    // up
            walkTo(map[r][c], grid, map, r+1, c, rQ, cQ);    // down
            walkTo(map[r][c], grid, map, r, c-1, rQ, cQ);    // right
            walkTo(map[r][c], grid, map, r, c+1, rQ, cQ);    // left
        }

        return -1;
    }

    private void walkTo(int pre, int[][] grid, int[][] map, int toR, int toC,
                       Queue<Integer> rQ, Queue<Integer> cQ) {
        if ((toR < 0 || toR == grid.length || toC < 0 || toC == grid[0].length || map[toR][toC] != 0)
                || (count < 1 && grid[toR][toC] == 1)) {
            return;
        }

        if (count >= 1 && grid[toR][toC] == 1) {
            count--;
            map[toR][toC] = pre;
            rQ.add(toR);
            cQ.add(toC);
        } else {
            map[toR][toC] = pre + 1;
            rQ.add(toR);
            cQ.add(toC);
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0,1,0,1},
                {0,1,0,0},
                {0,0,1,0},
                {1,0,0,1},
                {0,1,0,0}
        };
        ShortestPath_1293 sp = new ShortestPath_1293();
        int res = sp.shortestPath(m, 18);
        System.out.println(res);
    }
}
