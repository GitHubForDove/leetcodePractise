package com.example.leetcode.demo.Offer;

public class MoreThanHalfNum_Solution {


    public static int moreThanHalfNum(int[] array) {

        int count = 1;
        int res = array[0];
        for (int i=1; i<array.length; i++) {

            if (count == 0) {
                res = array[i];
                count = 1;
            } else {
                if (array[i] == res) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        int times = 0;
        for (int i=0; i<array.length; i++) {
            if (res == array[i]) {
                times++;
            }
        }

        if (times > array.length/2) {
            return res;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2,2,2,2,2,1,3,4,5};
        System.out.println(moreThanHalfNum(array));
    }
}
