package com.example.leetcode.demo.Offer;

public class HasSubtree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {

        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }


        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        // 递归去找 是否一样
        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);
    }

    //public static TreeNode

    public static void main(String[] args) {

    }
}