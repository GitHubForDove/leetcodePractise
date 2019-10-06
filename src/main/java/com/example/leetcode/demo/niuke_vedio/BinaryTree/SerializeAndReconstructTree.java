package com.example.leetcode.demo.niuke_vedio.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 前序序列化二叉树
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }

        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i=0; i < values.length; i++) {
            queue.offer(values[i]);
        }

        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        // 使用先序遍历再建立树结构
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        String res = serialByPre(root);
        System.out.println(res);
    }
}
