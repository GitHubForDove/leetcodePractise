package com.example.leetcode.demo.Leetcode;


/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 */

public class KthSmallest_200 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //public ArrayList<Integer> lists ;
    private int i = 0;
    private int n = 0;

    public int kthSmallest(TreeNode root, int k) {
        //lists = new ArrayList<>();
        preOrder(root, k);
        //return lists.get(k-1);
        return n;
    }


    public void preOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        preOrder(node.left, k);

        if (++i == k) {
            n = node.val;
        }
        //lists.add(node.val);
        preOrder(node.right, k);
    }



    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        KthSmallest_200 ks = new KthSmallest_200();
        int res = ks.kthSmallest(head, 1);
        System.out.println(res);
    }
}
