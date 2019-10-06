package com.example.leetcode.demo.VIPKID;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 寻找zero 组数
 */
public class Pair {


    public static int pair(int[] nums) {
       int begin = 0;
       int last = nums.length -1;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
       while (begin < last) {

           if (map.containsKey(nums[begin])) {

           }

           int tempSum = nums[begin] + nums[last];
           if (tempSum == 0) {
               cnt++;
               begin++;
               last--;
           } else if (tempSum < 0) {
               begin++;
           }else {
               last--;
           }
       }

       return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            str = str.replaceAll(" ", "");
            String[] arr = str.split("\\,");
            int[] num = new int[arr.length];

            for (int i=0; i<num.length; i++) {
                num[i] = Integer.valueOf(arr[i]);
            }
            System.out.println(pair(num));
        }
    }
}
