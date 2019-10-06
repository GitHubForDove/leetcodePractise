package com.example.leetcode.demo.Leetcode;


/**
 * 124. 二叉树中的最大路径和
 *
 * 给定一个非空二叉树，返回其最大路径和。

   本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxPathSum {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        path(root);
        return max;
    }

    public static int path(TreeNode node) {
        if (node == null) return 0;
        // 左边路径长度
        int left = Math.max(path(node.left), 0);
        // 右边路径长度
        int right = Math.max(path(node.right), 0);
        // 计算左加右 加父节点的值 是否大于 max
        max = Math.max(left+right+node.val, max);
        return Math.max(left + node.val, right + node.val);
    }


    public static void main(String[] args) {

    }
}
