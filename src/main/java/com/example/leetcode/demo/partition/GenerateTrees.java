package com.example.leetcode.demo.partition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-19
 * @descript 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 */


public class GenerateTrees {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        int n = 3;
        List<TreeNode> res = generateTrees(3);

        for (int i=0;i<res.size(); i++) {

            TreeNode node = res.get(i);
            while (node.right != null || node.left != null) {
                if (node.right != null) {
                    node = node.right;
                }
                if (node.left != null) {
                    System.out.println(node.left);
                    node = node.left;
                }
            }
        }



    }

    // 生成树  还可以直接给数组 然后通过数组构建树形结构
    public static List<TreeNode> generateTrees(int n) {
        if (n<1) {
            return new LinkedList<TreeNode>();
        }

        return generateSubtrees(1,n);  // 生成子树
    }

    public static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        // 递归终止条件
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int i=s; i <= e; ++i) {

            // 以i为界限 将树分为两个部分  构建左子树与右子树
            List<TreeNode> leftSubtrees = generateSubtrees(s, i-1); // 构建左子树
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e); // 构建右子树

            // 然后循环 构造不同的树形结构
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    // 构造完成后 添加到 res中
                    res.add(root);
                }
            }
        }

        return res;
    }
}
