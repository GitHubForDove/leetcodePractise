package com.example.leetcode.demo.AIQIYI;

import java.math.BigDecimal;
import java.util.Scanner;

public class RedAndBlueBall_2 {


    public static double result(int n, int m) {
        double res = 0;
        if (n ==0) {
            return res;
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            int n = Integer.valueOf(arr[0]);
            int m = Integer.valueOf(arr[1]);
            double res = result(n ,m);
            BigDecimal big = new BigDecimal(res);
            System.out.println( big.setScale(5,  BigDecimal.ROUND_HALF_UP));//保留5位小数，返回b
        }
    }
}
