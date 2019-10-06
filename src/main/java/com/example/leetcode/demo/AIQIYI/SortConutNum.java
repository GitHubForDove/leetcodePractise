package com.example.leetcode.demo.AIQIYI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortConutNum {


    // 使用boolean[] 来记录状态
    public static boolean[]  used ;

    public static int count = 0;

    public static void permute(int[] nums, int[] line) {
        count = 0;
        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        generatePermutetation(nums,0, list, line);
    }

    public static void generatePermutetation(int[] nums, int index, List<Integer> p, int[] line) {

        if (index == nums.length) {
            boolean flag = false;
            for (int i=0;i<line.length; i++) {
                if (line[i] == 0 && p.get(i) < p.get(i+1)) {
                    flag = true;
                } else if (line[i] == 1 && p.get(i) > p.get(i+1)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
            return;
        }
        for (int i=0;i<nums.length;i++) {
            // 判断是否nums[i]是否在p中
            if (!used[i]) {
                // nums[i]添加在p中
                p.add(nums[i]);
                used[i] = true;
                generatePermutetation(nums, index+1, new ArrayList<>(p), line);
                // 回溯 还原状态
                p.remove(p.size()-1);
                used[i] = false;
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.nextLine();
            str = sc.nextLine();
            String[] arr = str.split("\\ ");
           int[] nums = new int[n];
            int[] line = new int[arr.length];
            for (int i=1;i<=n; i++) {
                nums[i-1] = i;
            }

            for (int j=0;j<arr.length; j++) {
                line[j] = Integer.parseInt(arr[j]);
            }

            permute(nums, line);
            int number = (int)(Math.pow(10, 9) + 7);
            System.out.println(Math.floorMod(count, number));
        }
    }
}
