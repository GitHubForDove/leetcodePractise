package com.example.leetcode.demo.DataStructure;

import java.util.Stack;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-25
 * @descript 二叉树的遍历  递归与非递归
 *
 *
 */
public class BinaryTreeRecur {


    public  static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 思路： 使用栈作为树遍历节点的暂时存储容器，有右节点就先将右节点压入栈，然后再压入左节点，那么弹出来的时候
     *       就是左子节点先出来，再是右子节点弹出，这样可以模拟先序遍历
     *
     *       使用栈是因为树形结构只有向下的过程，我们需要一个可以让子节点回去的结构
     *
     *       stack.add(xx);  // 没有返回值
     *       stack.add(xx);  // 有返回值
     */
    public static void preOrderUnRecur(TreeNode head) {

        System.out.println("pre-order: ");
        if (head != null) {

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val);

                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }

            }
        }

        System.out.println();

    }


    /**
     * 思路： 使用栈作为树遍历的暂时存储容器，先将左边的子树全部压进栈中，当左边压完了就将最后一个压入栈中的节点
     *       弹出，然后打印当前节点，然后转移到右子节点。再进行前面的操作，直到所有的节点都遍历完，再从栈中弹出。
     *       这样就可以模拟中序遍历。
     */
    public static void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order: ");

        if (head != null) {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || head != null) {

                if (head.left != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val);
                    head = head.right;
                }


            }


        }


    }

    /**
     *  思路： 使用栈作为树遍历的暂时存储容器，不过使用两个栈。依据先序遍历的思想，不过是先左再右放入到栈中，
     *        然后将这个栈的的内容弹出到另一个栈中，那么再次从栈中弹出的顺序就是反的，也就是后续遍历执行的顺序。
     *
     */
    public static void lastOrderUnRecur(TreeNode head) {

        if (head != null) {

            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()) {

                head = s1.pop();
                s2.push(head);

                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()) {
                System.out.println(s2.pop().val);
            }
        }

    }

}
