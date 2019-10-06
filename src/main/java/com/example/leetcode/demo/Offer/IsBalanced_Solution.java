package com.example.leetcode.demo.Offer;

public class IsBalanced_Solution {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced_Solution(TreeNode root) {

        if (root == null) {
            return true;
        }

        // 判断深度是否超过1
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <=1) {
            return isBalanced_Solution(root.right) && isBalanced_Solution(root.left);
        } else {
            return false;
        }
    }

    public static int getDepth(TreeNode root) {
        if (root == null) return 0;

        int leftLevel = getDepth(root.left);
        int rightLevel = getDepth(root.right);

        return 1 + Math.max(leftLevel, rightLevel);
    }


    public static void main(String[] args) {

    }
}
