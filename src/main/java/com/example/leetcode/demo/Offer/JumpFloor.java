package com.example.leetcode.demo.Offer;

public class JumpFloor {

    public static int jumpFloor(int target) {

        if (target == 0) {
            return 1;
        }

        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        return jumpFloor(target-1) + jumpFloor(target-2);
    }

    public static void main(String[] args) {

    }
}
