package com.example.leetcode.demo.Offer;

public class TreeDepth {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }



    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = treeDepth(root.left);
        int rightLength = treeDepth(root.right);


        return 1 + Math.max(leftLength, rightLength);
    }

    public static void main(String[] args) {

    }
}
