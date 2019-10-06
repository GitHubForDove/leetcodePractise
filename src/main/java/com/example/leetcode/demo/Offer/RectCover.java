package com.example.leetcode.demo.Offer;

public class RectCover {


    public static int RectCover(int target) {

        if (target<= 0) {
            return 1;
        }

        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        return RectCover(target-1) + RectCover(target-2);
    }


    public static void main(String[] args) {

    }
}
