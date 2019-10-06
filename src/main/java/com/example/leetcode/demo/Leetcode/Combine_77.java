package com.example.leetcode.demo.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {

    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        DFS(n,k,1,list);
        return lists;
    }

    private static void DFS(int n, int k, int start, List<Integer> list) {

        if (n == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }

        //  i <= n-(k-list.size())+1 剪枝
        for (int i=start; i <= n; i++) {
            list.add(i);
            DFS(n,k,i+1,new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int n=4;
        int k =1;
        List<List<Integer>> res = combine(n,k);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
