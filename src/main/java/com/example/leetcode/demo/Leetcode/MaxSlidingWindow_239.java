package com.example.leetcode.demo.Leetcode;


import java.util.*;

/**
 * leetcode 239. 滑动窗口最大值
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow_239 {

    /**
     * 使用双端队列解决
     *  存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
     *
     *  算法
     *
     * 算法非常直截了当：
     *
     * 处理前 k 个元素，初始化双向队列。
     *
     * 遍历整个数组。在每一步 :
     *
     * 清理双向队列 :
     *
     *   - 只保留当前滑动窗口中有的元素的索引。
     *
     *   - 移除比当前元素小的所有元素，它们不可能是最大的。
     * 将当前元素添加到双向队列中。
     * 将 deque[0] 添加到输出中。
     * 返回输出数组。
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    /**
     * 暴力 破解
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            int len = i + k - 1;
            int max = Integer.MIN_VALUE;
            if (len >= n) {
                break;
            }
            while (len >= i) {
                max = Math.max(max, nums[len--]);
            }
            res[i] = max;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow_239 msw = new MaxSlidingWindow_239();
        int[] res = msw.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
