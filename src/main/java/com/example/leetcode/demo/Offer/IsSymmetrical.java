package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 对称的二叉树
 */
public class IsSymmetrical {


    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return false;
        }
        return  isSymmetrical(pRoot, pRoot);
    }

    public static boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // 递归比较 值
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);

    }

    public static void main(String[] args) {

        TreeNode pRoot = new TreeNode(3);
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(2);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right= new TreeNode(2);

        pRoot.right.right = new TreeNode(1);
        pRoot.right.left = new TreeNode(2);

        System.out.println(isSymmetrical(pRoot));
    }
}
