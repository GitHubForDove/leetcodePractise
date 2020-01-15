package com.example.leetcode.demo.Leetcode.UnionFind;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 200. 岛屿数量
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class NumIslands_200 {

    private static class UnionFind {
        /**
         * 父亲结点标识数组
         */
        private int[] parent;
        /**
         * 连通分量个数
         */
        private int count;

        public UnionFind(char[][] grid) {
            int len1 = grid.length;
            int len2 = grid[0].length;
            parent = new int[len1 * len2];
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * len2 + j;
                        parent[index] = index;
                        count++;
                    }
                }
            }
        }

        /**
         * 查找父节点
         */
        public int find(int index) {
            while (index != parent[index]) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }

        /**
         * 是否合并成功，如果 x 和 y 本来就在一个连通分量里，返回 false
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            count--;

            return true;
        }
    }

    private int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);

        int len1 = grid.length;
        int len2 = grid[0].length;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1') {

                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (isValid(grid, len1, len2, x, y)) {
                            unionFind.union(i * len2 + j, x * len2 + y);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }

    private boolean isValid(char[][] grid,  int x, int y,int len1, int len2) {
        return x >= 0 && y >= 0 && x < len1 && y < len2 && grid[x][y] == '1';
    }


    /**
     * 深度搜索 解决岛屿搜索问题
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int len1 = grid.length;
        int len2 = grid[0].length;
        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j, len1, len2);
                }
            }
        }

        return ans;
    }

    void dfs(char[][] grid, int r, int c, int len1, int len2) {
        if (r < 0 || c < 0 || r >= len1 || c >= len2 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c, len1, len2);
        dfs(grid, r + 1, c, len1, len2);
        dfs(grid, r, c - 1, len1, len2);
        dfs(grid, r, c + 1, len1, len2);
    }


    /**
     * 广度搜索
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int len1 = grid.length;
        int len2 = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] visited = new boolean[len1][len2];
        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    deque.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!deque.isEmpty()) {
                        int[] n = deque.pollFirst();

                        for (int[] d : directions) {
                            int x = n[0] + d[0];
                            int y = n[1] + d[1];
                            if (!visited[x][y] && isValid(grid, x, y, len1, len2)) {
                                deque.add(new int[]{x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumIslands_200 numIslands_200 = new NumIslands_200();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = numIslands_200.numIslands2(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = numIslands_200.numIslands2(grid2);
        System.out.println(numIslands2);
    }

}
