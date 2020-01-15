package com.example.leetcode.demo.Leetcode.DfsOrBfs;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 934. 最短的桥
 *
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 */
public class ShortestBridge_934 {

    private int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] A, int i, int j) {
        //为0则不是连通图(否则不连通)，为2则已经dfs过了(否则堆栈溢出)
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1)
            return;
        A[i][j] = 2;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }

    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int m = A.length;
        int n = A[0].length;
        boolean found = false;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!found && A[i][j] == 1) {//只将其中一个连通图变为2，即为连通图2
                    dfs(A, i, j);
                    found = true;
                } else if (found && A[i][j] == 1) {//另外一个连通图（即为连通图1）直接入队
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] head = deque.pollFirst();
                for (int[] d : directions) {
                    int x = head[0] + d[0];
                    int y = head[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (A[x][y] == 0) {
                            A[x][y] = 1;
                            deque.addLast(new int[]{x, y});
                        } else if (A[x][y] == 2)
                            return ans;
                    }
                }
            }
            ans++;
        }
        return 1;
    }
}
