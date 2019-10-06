package com.example.leetcode.demo.Offer;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {


    public static boolean verifySquenceOfBST(int [] sequence) {

        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }

        return isBST(sequence, 0, sequence.length-1);
    }

    // 判断是否符合二叉搜索树的规则
    public static boolean isBST(int[] sequence, int start, int end) {
        // 边界条件
        if(start >= end){
            return true;
        }
        // 先找根节点
        int root = sequence[end];

        // 找到第一个大于root的下标
        int index = start;
        while (sequence[index] < sequence[end]) {
            index++;
        }

        // 如果 后面还有小于root的值 说明不是二叉搜素树
        for(int j=index;j<end;j++){
            if(sequence[j] < root){
                return false;
            }
        }

        return isBST(sequence,0,index-1)
                && isBST(sequence, index,end-1);
    }


    public static void main(String[] args) {
        int[] sequence = new int[]{4,6,7,5};
        boolean res = verifySquenceOfBST(sequence);
        System.out.println(res);
    }
}
