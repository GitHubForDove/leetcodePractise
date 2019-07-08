package com.example.leetcode.demo.DataStructure;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-30
 * @descript 完全二叉树的节点个数
 */
public class NodeCountCompleteBinaryTree {

    public  static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 求出完全二叉树的全部节点数
     */
    public static int nodeNum(TreeNode head) {

        if (head == null) {
            return 0;
        }

        return bs(head, 1,mostLeftLevel(head,1));
    }

    public static int bs(TreeNode node, int level, int h) {

        // 递归的终止的边界条件 到最后一层的时候
        if (level == h) {
            return 1;
        }

        // 如果当前右子节点的高度 等于 整棵树的最长h 就可以判断
        // 左边的树形结构为 满二叉树 直接进行计算 再加上右边还未计算的节点数
        if (mostLeftLevel(node.right, level+1) == h) {
            // 1 << (h-level) 为2的h-level次方
            return (1 << (h - level)) + bs(node.right, level+1,h);
        // 如果当前节点的高度 小于整棵树的高度 那么说明 右边的树形结构 为满二叉树 使用满二叉树的计算公式计算
        } else {
            // 1 << (h-level - 1) 为2的h-level-1次方
            return (1 << (h - level-1)) + bs(node.left, level+1,h);
        }

    }


    /**
     * 求出左孩子树形结构的最大高度
     */
    public static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level ++;
            node = node.left;
        }

        // 减去自己的本身所在的一层高度
        return level - 1;
    }

}
