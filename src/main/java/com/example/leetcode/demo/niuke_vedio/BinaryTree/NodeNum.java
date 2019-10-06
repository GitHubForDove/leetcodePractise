package com.example.leetcode.demo.niuke_vedio.BinaryTree;


/**
 * 求完全二叉树的全部节点个数
 */
public class NodeNum {



    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }

        return bs(head, 1, mostLevel(head, 1));
    }


    public static int bs(Node node, int level, int h) {

        if (level == h) {
            return 1;
        }

        // 如果最右边树的高度等于树的高度 那么直接公式计算左边树一共有多少树节点个数
        if (mostLevel(node.right, level+1) == h) {
            return (1 << (h-level)) + bs(node.right, level+1, h);
        // 否则 公式计算减少一级层级的树节点个数
        } else {
            return (1 << (h-level-1)) + bs(node.left, level+1, h);
        }

    }

    // 求最大的高度
    public static int mostLevel(Node head, int level) {

        while (head != null) {
            level ++;
            head = head.left;
        }
        return level - 1;
    }
}
