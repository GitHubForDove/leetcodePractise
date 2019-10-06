package com.example.leetcode.demo.Offer;

import java.util.Stack;

public class Convert {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }


    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode p = root;
        TreeNode pre = null;    // 用于保存中序遍历序列的上一节点
        boolean isFirst = true;

        Stack<TreeNode> s = new Stack<>();
        while (p != null || !s.empty()) {

            while (p != null) {
                s.push(p);
                p = p.left;
            }

            p = s.pop();
            if (isFirst) {
                root = p; // 将中序遍历的第一个节点记为root
                pre = root;
                isFirst = false;

            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }

        return root;
    }


    public static void main(String[] args) {

    }
}
