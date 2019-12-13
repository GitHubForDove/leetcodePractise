package com.example.leetcode.demo.Leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode109 有序链表转换为二叉搜索树
 *
 * 有序链表转换为二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedListToBST_109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return  buildTree(list, 0, list.size()-1);
    }

    public TreeNode buildTree(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, l, mid-1);
        root.right = buildTree(list, mid+1, r);
        return root;
    }

}
