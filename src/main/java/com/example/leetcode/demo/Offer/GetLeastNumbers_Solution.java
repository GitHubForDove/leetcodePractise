package com.example.leetcode.demo.Offer;

import java.util.*;

public class GetLeastNumbers_Solution {


    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {

        if (k>input.length) {
            return null;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,(o1, o2) -> o2-o1);

        for (int i=0; i<k;i++) {
            heap.add(input[i]);
        }

        for (int i=k; i<input.length; i++) {
            if (heap.peek() > input[i]) {
                heap.poll();
                heap.add(input[i]);
            }
        }
        Object[] arr = heap.toArray();
        ArrayList<Integer> res = new ArrayList<>();
        for (Object ob : arr) {
            res.add((Integer)ob);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(getLeastNumbers_Solution(input, 4));
    }
}
