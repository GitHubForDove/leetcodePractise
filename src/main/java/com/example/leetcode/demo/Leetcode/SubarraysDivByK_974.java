package com.example.leetcode.demo.Leetcode;


import java.util.Arrays;

/**
 * 974. 和可被 K 整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 */
public class SubarraysDivByK_974 {

    public static int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int[] arr = new int[A.length+1];
        // 数组前缀和
        for (int i=0;i < A.length; ++i) {
            arr[i+1] = arr[i] +  A[i];
        }

        int[] count = new int[K];

        for (int x : arr) {
            //为啥不是arr[i]%K的原因是除去负数的存在
            count[(x % K + K) % K]++;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(count));

        for (int v: count)
            // 任意两个模相同的位置之间的子数组符合要求
            res += v * (v - 1) / 2;
        return res;
    }

    public static int subarraysDivByK2(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        int[] mod = new int[k];
        mod[0] = 1;
        for (int num : nums) {
            sum += num;
            int m = sum % k;
            if (m < 0) {
                m += k;
            }
            ans += mod[m]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] A = new int[]{4,5,0,-2,-3,1,9};
        int K = 5;
        int res = subarraysDivByK(A, K);
        System.out.println(res);
    }
}
