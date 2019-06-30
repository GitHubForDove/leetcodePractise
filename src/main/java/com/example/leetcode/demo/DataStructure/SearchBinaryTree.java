package com.example.leetcode.demo.DataStructure;

import java.util.Stack;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-30
 * @descript 搜索二叉树 BST
 */
public class SearchBinaryTree {


    public  static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 二叉树的中序遍历 判断前一个值 是否小于后面一个树  如果不是  返回false 如果全部遍历完 全部符合 返回true
     */
    public static boolean isSearchBinaryTree(TreeNode head) {
        System.out.println("in-order: ");
        int pre = Integer.MIN_VALUE;
        if (head != null) {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || head != null) {

                if (head.left != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();

                    // 中序遍历打印的时机 进行比较  判断是否是搜索二叉树
                    if (head.val > pre) {
                        pre = head.val;
                    }else {
                        return false;
                    }
                    head = head.right;
                }


            }


        }

        return true;

    }


}
