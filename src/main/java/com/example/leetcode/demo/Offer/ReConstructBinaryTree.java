package com.example.leetcode.demo.Offer;


import java.util.Arrays;

/**
 * 重建二叉树
 */
public class ReConstructBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }

        int rootVal = pre[0];

        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }

        int rootIndex = 0;
        // 找到中序中 rootIndex
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),
                Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length));

        return root;

    }
}
