package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 */
public class ConstructMaximumBinaryTree_654 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        return constructBinaryTree(nums, 0,length-1);
    }

    public TreeNode constructBinaryTree(int[] nums, int low, int high) {

        if (low > high || high > nums.length || low < 0) {
            return null;
        }
        int maxIndex = findMax(nums, low, high);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructBinaryTree(nums, low, maxIndex-1);
        node.right = constructBinaryTree(nums, maxIndex+1, high);

        return node;
    }

    public int findMax(int[] nums, int low, int high) {
        if (low>high) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = low;
        for (int i=low; i<=high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public  void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        ConstructMaximumBinaryTree_654 cmbt = new ConstructMaximumBinaryTree_654();
        TreeNode res = cmbt.constructMaximumBinaryTree(nums);
        cmbt.printBinaryTree(res);
    }
}
