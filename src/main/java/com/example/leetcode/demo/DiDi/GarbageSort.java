package com.example.leetcode.demo.DiDi;

import java.util.ArrayList;
import java.util.Scanner;

public class GarbageSort {


    public static int maxGarbage(int n, ArrayList<ArrayList<Integer>> lists) {

        return lists.get(0).get(1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
            for (int i=0; i<m;i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(sc.nextInt());
                list.add(sc.nextInt());
                listAll.add(list);
            }
            int res = maxGarbage(n, listAll);
            System.out.println(res);
        }


    }
}
