package com.example.leetcode.demo.Leetcode;


import java.util.Stack;

/**
 * leetcode 907
 * 子数组的最小值之和
 * <p>
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 */
public class SumSubarrayMins_907 {

    public static int sumSubarrayMins(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                }
                sum += min;
            }
        }
        sum = sum % 1000000007;
        return (int) sum;
    }

    public static int sumSubarrayMins2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int j, k, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > (i == A.length ? 0 : A[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + A[j] * (i - j) * (j - k)) % 1000000007;
            }
            stack.push(i);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        int res = sumSubarrayMins2(arr);
        System.out.println(res);
    }
}
