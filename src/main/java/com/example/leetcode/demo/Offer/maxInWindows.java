package com.example.leetcode.demo.Offer;

import java.util.*;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-27
 * @descript 滑动窗口的最大值
 */
public class maxInWindows {

    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(maxInWindows(num, size));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        /*PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1); //大顶堆


        if (num.length <= size) {

            for (int i = 0; i < num.length; i++) {
                maxHeap.add(num[i]);
            }
            res.add(maxHeap.poll());
            return res;

        } else {

            for (int i = 0; i < size; i++) {
                maxHeap.add(num[i]);
            }

            for (int j=size; j < num.length;j++) {
                res.add(maxHeap.poll());
                maxHeap.add(num[j]);
            }

        }

        return res;*/

        if(size == 0) return res;
        int begin;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;

            if(q.isEmpty())
                q.add(i);
            else if(begin > q.peekFirst())
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();

            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;

    }


    public ArrayList maxInWindows_2(int[] num, int size) {
        ArrayList res = new ArrayList();
        // 如果滑动窗口的length要大于num的长度 返回空
        if (size > num.length || size < 1) return res;
        // 构建最大堆，即堆顶元素是堆的最大值。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1); //大顶堆

        for (int i = 0; i < size; i++) maxHeap.add(num[i]);
        res.add(maxHeap.peek());
        // 从index=1 开始  继续往前滑动 计算所有的最大值
        for (int i = 1; i + size - 1 < num.length; i++) {
            maxHeap.remove(num[i - 1]);
            maxHeap.add(num[i + size - 1]);
            res.add(maxHeap.peek());
        }
        return res;
    }




}
