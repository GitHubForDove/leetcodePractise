package com.example.leetcode.demo.Offer;

import java.util.ArrayList;

public class PrintMinNumber {


    public static String max;
    public static ArrayList<ArrayList<String>> listAll = new ArrayList<>();
    public static boolean[] visited;

    public static String printMinNumber(int [] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        visited = new boolean[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            max += numbers[i];
        }
        ArrayList<String> list = new ArrayList<>();
        dfs(list, numbers);
        for (ArrayList<String> lists : listAll) {
            String temp = "";
            for (int j=0; j<lists.size(); j++) {
                   temp += lists.get(j);
            }

            if (temp.compareTo(max) < 0) {
                max = temp;
            }
        }
        return max;
    }

    public static void dfs(ArrayList<String> list, int[] numbers) {

        if (list.size() == numbers.length) {
            listAll.add(list);
            return;
        }

        for (int i=0; i<numbers.length; i++) {
            if (!visited[i]) {

                visited[i] = true;
                list.add(numbers[i] + "");
                dfs(new ArrayList<>(list), numbers);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3334,3,3333332};
        String max = printMinNumber(numbers);
        System.out.println(max);
    }
}
