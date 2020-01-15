package com.example.leetcode.demo.Leetcode;


import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * <p>
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum *= nums[i];
            } else {
                count++;
            }
        }

        if (count >= 2) {
            return res;
        } else if (count == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = sum;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = sum / nums[i];
            }
        }

        return res;
    }

    /**
     *  思路：
     *  前缀积 和 后缀积
     *  从头开始 前缀积
     *  从后往前 后缀积
     */
    public int[] productExceptSelf2(int[] nums) {
        if(nums.length==0||nums==null) return null;
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int tmp = 1;
        for(int i = nums.length-2;i>=0;i--){
            tmp*=nums[i+1];
            res[i]*=tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,0,0};
        ProductExceptSelf_238 pes = new ProductExceptSelf_238();
        int[] res = pes.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
