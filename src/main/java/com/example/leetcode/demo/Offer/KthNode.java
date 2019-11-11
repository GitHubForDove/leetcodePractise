package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 二叉搜索树的第K个节点
 */
public class KthNode {

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
     * 中，按结点数值大小顺序第三小结点的值为4。
     */


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static int index = 0; //计数器

    public static TreeNode kthNode(TreeNode pRoot, int k) {

        // 中序遍历
        if (pRoot != null) {
            TreeNode node = kthNode(pRoot.left, k);

            if (node != null) {
                return node;
            }
            index ++;

            if (index == k) {
                return pRoot;
            }

            node  = kthNode(pRoot.right, k);

            if(node != null) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(3);
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(4);
        pRoot.left.left = new TreeNode(1);
        pRoot.right.right = new TreeNode(6);

        TreeNode node = kthNode(pRoot, 4);

        System.out.println(node.val);
    }


}

