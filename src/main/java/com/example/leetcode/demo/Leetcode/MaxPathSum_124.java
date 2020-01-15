package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 124. 二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 */
public class MaxPathSum_124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPath(root.left);
        int right = maxPath(root.right);
        max = Math.max(root.val + right + left, max);
        int temp = Math.max(left, right) + root.val;
        return Math.max(temp, 0);
    }
}
