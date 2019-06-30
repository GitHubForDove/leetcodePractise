package com.example.leetcode.demo.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-30
 * @descript 完全二叉树 的一些题的集合
 */
public class ComleteBinaryTree {

    public  static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *  1、父节点有右孩子没左孩子  一个不是完全二叉树 返回false
     *  2、如果有左没有右 那么左节点一定得是叶子节点  要不然返回false
     */


    public static boolean isCompleteBinaryTree(TreeNode head) {

        if(head == null) {
            return true;
        }

        // 用于标志 是否是叶子节点
        boolean leaf = false;
        TreeNode l,r;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        while (!queue.isEmpty()) {

            // 这块代码 就是判断当前的节点是否是完全二叉树 并判断当前节点是否是 叶子节点
            {
                // -------------------------

                head = queue.poll();
                l = head.left;
                r = head.right;

                // 如果是叶子节点 那么左子节点存在 或者 右子节点存在 返回false
                // 如果左子节点不存在  但是右子节点存在 肯定不是完全二叉树 返回false
                if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                    return false;
                }

                if (l != null) {
                    queue.offer(l);
                }
                if (r != null) {
                    queue.offer(r);
                }
                if (l == null || r == null) {
                    // 左子节点为空 或者 右子节点为空 那么为叶子节点
                    leaf = true;
                }
            // -------------------------
            }
        }
        return true;
    }



}
