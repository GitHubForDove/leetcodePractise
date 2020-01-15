package com.example.leetcode.demo.Leetcode.weeklyContest.number171;


/**
 * 5309. 连通网络的操作次数 显示英文描述
 *
 * 题目难度Medium
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，
 * 其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
 * 请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 */
public class MakeConnected {

    private class UnionFind {
        /**
         * 父亲结点标识数组
         */
        private int[] parent;
        /**
         * 连通分量个数
         */
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩（隔代压缩）
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * @param x
         * @param y
         * @return 是否合并成功，如果 x 和 y 本来就在一个连通分量里，返回 false
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

    public int makeConnected(int n, int[][] connections) {
        // 特判
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);

        // 多余的边的条数
        int cnt = 0;

        for (int[] connection : connections) {
            boolean success = unionFind.union(connection[0], connection[1]);
            if (!success) {
                cnt++;
            }
        }

        // 特判
        if (unionFind.count == 1) {
            return 0;
        }

        // 扣掉的 1 是当前结点数最大的连通分量
        if (cnt < unionFind.count - 1) {
            return -1;
        }
        return unionFind.count - 1;
    }
}
