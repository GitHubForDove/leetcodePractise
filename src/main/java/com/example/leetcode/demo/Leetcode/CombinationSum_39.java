package com.example.leetcode.demo.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    static List<List<Integer>> listAll = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();

        DFS(0, list, candidates, target);
        return listAll;
    }

    public static void DFS(int start, List<Integer> lists, int[] candidates, int target) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            listAll.add(new ArrayList<>(lists));
            return;
        } else {
            for (int i=start; i<candidates.length; i++) {
                lists.add(candidates[i]);
                // 这里加入start 是因为这样的情况 可以让start 不停的取到递归
                DFS(i, lists, candidates, target-candidates[i]);
                lists.remove(lists.size()-1);
            }
        }
    }

    public static void main(String[] args) {


        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> res = combinationSum(candidates, target);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

        System.out.println();
    }
}
