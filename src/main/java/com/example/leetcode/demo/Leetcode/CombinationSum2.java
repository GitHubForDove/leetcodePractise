package com.example.leetcode.demo.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    static List<List<Integer>> listAll = new ArrayList<>();
    static boolean[] used ;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        DFS(list,0, candidates, target);
        return listAll;
    }

    public static void DFS(List<Integer> list, int index, int[] candidates, int target) {

        if (target < 0) return;//target<0
        if (target == 0) {
            listAll.add(list);
            return;
        }

        for (int i=index; i<candidates.length; i++) {

            // 去重
            if (i != index && candidates[i] == candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            DFS(new ArrayList<>(list),i+1, candidates, target-candidates[i]);
            list.remove(list.size()-1);
            }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
