package com.example.leetcode.demo.Offer;

public class Mirror {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }

        TreeNode temp = new TreeNode(0);
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }



    public static void main(String[] args) {

    }
}
