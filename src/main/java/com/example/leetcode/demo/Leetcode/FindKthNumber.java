package com.example.leetcode.demo.Leetcode;

/**
 * 乘法表中的第k小的数
 */
public class FindKthNumber {

    /**
     * leetcode 668
     */

    public static int findKthNumber(int m, int n, int k) {

        // 使用二分的思想，找出第k大的数
        int low = 1;
        int high = m * n + 1;

        while (low < high) {

            int mid = (low + high) /2;
            //计算乘法表中不大于mid的元素个数
            int cnt = find(m,n,mid);

            if (cnt >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low;

    }

    public static int find(int m, int n, int k) {

        int count = 0;
        //对乘法表的每一行（每一行都是递增）进行搜索，muns[row][col] = row * col
        for (int i=1; i <= m; i++) {
            //num/i 代表的是如果k也在第i行，它存在的列数，而一行最多只有n个
            count += Math.min(k/i, n);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(3,3,5));
    }
}
