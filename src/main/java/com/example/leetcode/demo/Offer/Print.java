package com.example.leetcode.demo.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 把二叉树打印多行
 */
public class Print {

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        if (pRoot == null) return res;

        Queue queue = new LinkedList();
        queue.add(pRoot);
        temp.add(pRoot.val);
        res.add(temp);

        while (!queue.isEmpty()) {
            Queue tempQueue = new LinkedList();
            ArrayList<Integer> tempList = new ArrayList<>();

            while (!queue.isEmpty()) {

                TreeNode tempNode = (TreeNode) queue.poll();
                if (tempNode.left != null) {
                    tempList.add(tempNode.left.val);
                    tempQueue.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    tempList.add(tempNode.right.val);
                    tempQueue.add(tempNode.right);

                }
            }
            if (tempList.size()>0) {
                res.add(tempList);
            }

            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.poll());
            }

        }
        return res;
    }


    /**
     * 牛客网大佬做的  使用层次遍历 遍历之后再对list进行填充值
     */
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private static void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }


    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(3);
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(4);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right= new TreeNode(10);

        pRoot.right.right = new TreeNode(6);
        pRoot.right.left = new TreeNode(11);

        ArrayList<ArrayList<Integer>> res = print(pRoot);

        for (int i=0; i<res.size();i++) {
            System.out.println(res.get(i));

        }

        ArrayList<ArrayList<Integer>> res2 = Print(pRoot);

        for (int i=0; i<res.size();i++) {
            System.out.println(res2.get(i));

        }
    }
}
