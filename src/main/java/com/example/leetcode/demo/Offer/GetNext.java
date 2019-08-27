package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript xx
 */
public class GetNext {

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * 分析二叉树的下一个节点，一共有以下情况：
     * 1.二叉树为空，则返回空；
     * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节
     *
     */

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {

        // 1
        if (pNode == null) {
            return null;
        }

        // 2
        if (pNode.right != null) {

            pNode = pNode.right;

            while (pNode.left != null) {
                pNode = pNode.left;
            }

            return pNode;
        }

        // 3
        while (pNode.next != null) {

            TreeLinkNode pRoot = pNode.next;

            if (pRoot.left == pNode) {
                return pRoot;
            }

            pNode = pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
