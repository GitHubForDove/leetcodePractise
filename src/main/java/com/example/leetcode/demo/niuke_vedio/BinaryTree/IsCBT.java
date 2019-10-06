package com.example.leetcode.demo.niuke_vedio.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 */
public class IsCBT {


    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isCBT(Node root) {

        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {

            Node head = queue.poll();

            Node l = head.left;
            Node r = head.right;

            // 判断临界条件
            if ((isLeaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }

            // 先加左 再加右
            if (l != null) {
                queue.offer(l);
            }

            if (r != null) {
                queue.offer(r);
            }

            if (l == null || r == null){
                isLeaf = true;
            }
        }
        return true;
    }
}
