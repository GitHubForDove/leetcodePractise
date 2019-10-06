package com.example.leetcode.demo.WeiZhong;

import java.util.Scanner;

public class Question1 {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = solve(num);
        System.out.print(result);
    }

    private static int solve(int num) {
        int a = num / 10;
        int b = num % 10;
        int result = 1;
        if (a != 0) {
            if ((a % 2) == 1) {
                result = 4;
            } else {
                result = 6;
            }
        }

        int temp = 0;
        if (num == 1 || num == 2 || num ==3 || num ==4) {
            switch (num) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 6;
                case 4:
                    return 4;
            }
        } else {
            temp = temp + solve(num / 5);
        }

        result = result * temp;
        if (b < 5) {
            for (int i = 1; i <= b; i++) {
                result *= i;
            }
        } else {
            for(int i = 3; i <= b; i++) {
                if (i == 5) continue;
                result *= i;
            }
        }

        return result % 10;
    }
}
