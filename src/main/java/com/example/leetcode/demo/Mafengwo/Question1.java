package com.example.leetcode.demo.Mafengwo;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            int begin = str.indexOf("【");
            int end = str.indexOf("】");
            str = str.substring(begin+1, end-1);
            str = str.replaceAll(" ", "");
            String[] strArr = str.split("，");
            int[] arr = new int[strArr.length];
            for (int i=0; i<strArr.length; i++) {
                arr[i] = Integer.valueOf(strArr[i]);
            }

            ArrayList<Integer> res = findPeak(arr);
            for (int index : res) {
                System.out.println(index);
            }
        }

    }

    public static ArrayList<Integer> findPeak(int[] nums) {
        ArrayList<Integer> peak = new ArrayList<Integer>();
        for (int index = 1; index <= nums.length - 2; ) {
            //判断是否峰点
            if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
                peak.add(index);
                index += 2;
            } else if (nums[index] < nums[index-1] && nums[index] < nums[index + 1]){
                peak.add(index);
                index +=2;
            } else {
                index += 1;
            }
        }

        return peak;
    }
}
