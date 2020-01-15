package com.example.leetcode.demo.Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */
public class PathSum_437 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Map<Integer, Integer> count;
    int ans;

    public int pathSum(TreeNode root, int sum) {
        count = new HashMap<>();
        count.put(0, 1);  // 重要
        dfs(root, 0, sum);
        return ans;
    }

    public void dfs(TreeNode node, int sum, int t) {
        if (node == null) {
            return;
        }

        int cur = sum + node.val;
        if (count.containsKey(cur - t)) {
            ans += count.get(cur - t);
        }
        count.put(cur, count.getOrDefault(cur, 0) + 1);
        dfs(node.left, cur, t);
        dfs(node.right, cur, t);
        count.put(cur, count.get(cur) - 1);

    }
}
