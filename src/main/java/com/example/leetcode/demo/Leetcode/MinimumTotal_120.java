package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class MinimumTotal_120 {

    /**
     * 贪心 无法得到最优解
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int minPath = 0;
        int index = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int tmpMin = Integer.MAX_VALUE;
            int end = index;
            if (index + 1 <= list.size() - 1) {
                end = index + 1;
            }
            for (int j = index; j <= end; j++) {
                int tmp = list.get(j);
                if (tmpMin > tmp) {
                    tmpMin = tmp;
                    index = j;
                }
            }
            minPath += tmpMin;
        }
        return minPath;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        dfs(triangle, 0, triangle.get(0).size()-1, 0, 0);
        return minSum;
    }

    int minSum = Integer.MAX_VALUE;
    public void dfs(List<List<Integer>> triangle, int start, int end, int sum, int count) {
        if (count == triangle.size()) {
            minSum = Math.min(sum, minSum);
            return;
        }

        for (int i=start; i<=end; i++) {
            List<Integer> list = triangle.get(count);
            if (i<=end) {
                count++;
                sum += list.get(i);
                dfs(triangle, i, i+1, sum, count);
                sum -= list.get(i);
                count--;
            } else {
                count++;
                sum += list.get(i);
                dfs(triangle, i, i, sum, count);
                sum -= list.get(i);
                count--;
            }
        }
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for (int i = triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0 ; j< curTr.size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        MinimumTotal_120 mt = new MinimumTotal_120();
        int res = mt.minimumTotal2(triangle);
        System.out.println(res);
    }
}
