package com.example.leetcode.demo.Offer;

import java.util.ArrayList;

public class FindPath {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null || target == 0) {
            return allList;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, root, target);

        return allList;
    }

    public static void dfs(ArrayList<Integer> list, TreeNode root, int target) {

        if (target < 0) {
            return;
        }

        if ((target == root.val) && root.left == null && root.right == null) {
            list.add(root.val);
            allList.add(list);
            return;
        }

        if (root.left != null) {
            list.add(root.val);
            dfs(new ArrayList<>(list), root.left, target-root.val);
            list.remove(list.size()-1);
        }

        if (root.right != null) {
            list.add(root.val);
            dfs(new ArrayList<>(list), root.right, target-root.val);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {

    }
}
