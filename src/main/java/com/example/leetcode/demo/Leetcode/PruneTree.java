package com.example.leetcode.demo.Leetcode;

public class PruneTree {


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }

    public static TreeNode pruneTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 从下到上依次遍历
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }



    public static void main(String[] args) {

    }
}
