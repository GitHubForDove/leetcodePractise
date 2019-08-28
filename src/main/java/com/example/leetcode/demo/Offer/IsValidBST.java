package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript 是否是有效的二叉搜索树
 */
public class IsValidBST {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static long pre = Long.MIN_VALUE;
    private static boolean valid = true;

    public static boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        return valid;
    }

    private static void inOrderTraversal(TreeNode root){
        if(valid && root != null){
            inOrderTraversal(root.left);

            if(root.val <= pre){
                valid = false;
            }
            pre = root.val;

            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(isValidBST(root));
    }


}
