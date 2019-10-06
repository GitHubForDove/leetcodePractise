package com.example.leetcode.demo.VMWARE;

import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {


    /**
     * 九九的密码箱非常神奇，总共有N个位置需要填入数字，并且只能用1到N这N个数字分别填入到这N个位置中，
     * 每个数字必须使用且使用一次，而且还有一个特殊的要求，就是相邻两个位置的数字加起来必须为一个质数，
     * 其中1和N也算相邻，这下九九犯难了，九九只知道第一位为1，希望你能告诉她完整密码是多少。

     N<=17
     */

    public static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public static boolean[] visited;

    public static ArrayList<ArrayList<Integer>> findPassword(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        if (n == 1) {
            listAll.add(list);
            return listAll;
        }

        visited = new boolean[n];
        visited[0] = true;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i=1; i<arr.length; i++) {
            arr[i] = i+1;
        }

        dfs(list, arr);

        return listAll;
    }

    public static void dfs(ArrayList<Integer> list, int[] arr) {

        if (list.size() == arr.length) {
            listAll.add(list);
            return;
        }


        for (int i=1;i < arr.length; i++) {
            if (!visited[i]) {

                if (isPrimNum(list.get(list.size()-1) + arr[i])) {
                    visited[i] = true;
                    list.add(arr[i]);
                    dfs(new ArrayList<>(list), arr);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }

    }

    public static boolean isPrimNum(int num) {
        if (num <= 3) {
            return num > 1;
        }
        int sqrt = (int)Math.sqrt(num);
        for(int i=2;i<=sqrt;i++) {
            if(num % i == 0) {
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> res = findPassword(n);
            for (ArrayList list : res) {
                for (int i=0; i<list.size(); i++) {
                    System.out.print(list.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }
            listAll.clear();
        }
    }
}
