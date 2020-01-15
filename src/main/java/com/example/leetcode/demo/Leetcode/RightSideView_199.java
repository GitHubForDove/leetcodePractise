package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 */



public class RightSideView_199 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)  {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        res.add(root.val);
        while (!queue1.isEmpty()) {
            int temp = Integer.MIN_VALUE;
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    temp = node.left.val;
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    temp = node.right.val;
                    queue2.offer(node.right);
                }
            }
            if (temp != Integer.MIN_VALUE) {
                res.add(temp);
            }
            queue1 = queue2;
        }

        return res;
    }

    /**
     * 使用递归完成 先向右子树搜索 每次向下 n都 ++ 如果 和 list的大小相等 说明是最有的节点
     */
    public List<Integer> rightSideView2(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        assembly(root, result, 1);

        return result;
    }

    private void assembly(TreeNode root, List<Integer> result, int n) {

        if (result.size() == n - 1) {
            result.add(root.val);
        }

        if (root.right != null) {
            assembly(root.right, result, n + 1);
        }
        if (root.left != null) {
            assembly(root.left, result, n + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        RightSideView_199 rsv = new RightSideView_199();
        List<Integer> res = rsv.rightSideView(root);
        System.out.println(res);
    }
}
