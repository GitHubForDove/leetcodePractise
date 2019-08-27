package com.example.leetcode.demo.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 按之字形顺序打印二叉树
 */
public class PrintZ {

    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static ArrayList<ArrayList<Integer>> printZ(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        Queue queue = new LinkedList();
        queue.add(pRoot);
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(pRoot.val);
        res.add(tmp);

        Stack stack = new Stack();
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList tempList = new ArrayList();

            while (!queue.isEmpty()) {
                TreeNode tempNode = (TreeNode) queue.poll();

                if (flag) {
                    if (tempNode.left != null) {
                        tempList.add(tempNode.left.val);
                        stack.push(tempNode.left);
                    }

                    if (tempNode.right != null) {
                        tempList.add(tempNode.right.val);
                        stack.push(tempNode.right);
                    }
                } else {
                    if (tempNode.right != null) {
                        tempList.add(tempNode.right.val);
                        stack.push(tempNode.right);
                    }

                    if (tempNode.left != null) {
                        tempList.add(tempNode.left.val);
                        stack.push(tempNode.left);
                    }
                }
            }

            if (tempList.size()>0) {
                res.add(tempList);
            }

            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }

            flag = !flag;


        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(3);
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(4);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right= new TreeNode(10);

        pRoot.right.right = new TreeNode(6);
        pRoot.right.left = new TreeNode(11);

        pRoot.left.left.left = new TreeNode(13);
        pRoot.left.left.right= new TreeNode(10);

        pRoot.right.right.right = new TreeNode(6);
        pRoot.right.left.left = new TreeNode(11);


        ArrayList<ArrayList<Integer>> res = printZ(pRoot);

        for (int i=0; i<res.size();i++) {
            System.out.println(res.get(i));

        }
    }

}
