package com.example.leetcode.demo.Offer;

import java.util.Stack;

public class PosOrderUnRecur {

    public static class Node {

        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

    }

    public static void posOrderUnRecur(Node head) {

        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);

            while (!s1.empty()) {

                head = s1.pop();
                s2.push(head);

                if (head.left != null) {
                    s1.push(head.left);
                }

                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.empty()) {
                System.out.println(s2.pop().val);
            }
        }
    }



}
