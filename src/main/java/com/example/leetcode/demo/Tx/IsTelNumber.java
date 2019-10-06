package com.example.leetcode.demo.Tx;

import java.util.Scanner;

public class IsTelNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int len = scanner.nextInt();
            String str = scanner.next();
            if (func(str, len)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean func(String str, int len) {
        if (len < 11) {
            return false;
        } else {
            for (int i = 0; i <= len - 11; i++) {
                if (str.charAt(i) == '8') {
                    return true;
                }
            }
        }
        return false;
    }

}
