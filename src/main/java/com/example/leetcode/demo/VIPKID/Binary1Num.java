package com.example.leetcode.demo.VIPKID;


import java.util.Scanner;

/**
 * 求整数二进制1的个数
 */
public class Binary1Num {


    public static int binary1Num(int num) {
        int count = 0;
        while(num != 0){
            count++;
            num = num & (num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(binary1Num(num));
        }
    }
}
