package com.example.leetcode.demo.Leetcode;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap_48 {

    /**
     * 思路：
     * 先找左边的，再找右边的 每次都跟找到左右两边最高的柱子， 然后在两个之中选择最根柱子。
     * 与当前之差就是能够接水的容量大小。
     */
    public static int trap(int[] height) {

        int sum = 0;

        for (int i = 1; i < height.length; i++) {

            int max_left = 0;
            // 找出左边的最高点
            for (int j = i - 1; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            int max_right = 0;
            // 找出右边的最高点
            for (int k = i + 1; k < height.length; k++) {
                max_right = Math.max(max_right, height[k]);
            }

            int min = Math.min(max_left, max_right);

            sum += min > height[i] ? min - height[i] : 0;
        }

        return sum;
    }

    /**
     * 解法2：
     * 思路： 先找到最高的那个柱子 然后左边从0开始向最高柱子的下标方向走 右边 从最右的方向走 每次比较如果比当前的柱子要小
     * 那么就说明可以节水 相减累加结果。
     */
    public static int trap2(int[] height) {

        if (height.length < 2) return 0;
        int max = height[0];
        int max_index = 0;

        for (int i=0; i<height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                max_index = i;
            }
        }

        int area = 0;
        int temp = height[0];
        for (int i=0; i<max_index; i++) {
            if (height[i] > temp) {
                temp = height[i];
            } else {
                area += (temp-height[i]);
            }
        }

        temp = height[height.length-1];
        for (int i=height.length-1; i > max_index; i--) {
            if (height[i] > temp) {
                temp = height[i];
            } else {
                area += (temp - height[i]);
            }
        }

        return area;
    }

    /**
     * 解法3：
     * 思路：这种方法是基于动态规划 Dynamic Programming 的，维护一个一维的 dp 数组，
     * 这个 DP 算法需要遍历两遍数组，第一遍在 dp[i] 中存入i位置左边的最大值，然后开始第二遍遍历数组，第二次遍历时找右边最大值，
     * 然后和左边最大值比较取其中的较小值，然后跟当前值 A[i] 相比，如果大于当前值，则将差值存入结果
     */
    public static int trap3(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0) res += dp[i] - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap3(height);
        System.out.println(res);
    }
}
