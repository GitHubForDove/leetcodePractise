package com.example.leetcode.demo.BaiXinBank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {


    public static BigInteger func(int a, int t) {

        BigInteger ans1 = new BigInteger("1");
        while(t > 0){
            ans1 = ans1.multiply(BigInteger.valueOf(t));
            t -= 1;
        }

        BigInteger ans2 = BigInteger.valueOf(a);
        ans2 = ans2.pow(t);
        if (ans1.compareTo(ans2) >= 1) {
            return ans1.mod(BigInteger.valueOf(9999991));
        } else {
            return ans2.mod(BigInteger.valueOf(9999991));
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ArrayList<BigInteger> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int i=0; i<n; i++) {
                int a = sc.nextInt();
                int t = sc.nextInt();
                BigInteger res = func(a, t);
                list.add(res);
            }
            for (BigInteger num : list) {
                System.out.println(num);
            }

        }
    }
}
