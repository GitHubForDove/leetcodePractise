package com.example.leetcode.demo.Leetcode;

/**
 * 700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * <p>
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
public class SearchBST_700 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            TreeNode left = searchBST(root.right, val);
            if (left != null) {
                return left;
            }
        } else {
            TreeNode right = searchBST(root.left, val);
            if (right != null) {
                return right;
            }
        }
        return null;
    }

//    public TreeNode search(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right = new TreeNode(7);

        TreeNode res = searchBST(head, 2);
        if (res != null) {
            System.out.println(res.val);
        } else {
            System.out.println("NULL!");
        }
    }
}
