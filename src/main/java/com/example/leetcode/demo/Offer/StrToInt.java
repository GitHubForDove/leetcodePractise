package com.example.leetcode.demo.Offer;

import java.util.Scanner;

public class StrToInt {

    // 判断是否发生异常
    public static boolean flag;
    public static int strToInt(String str) {
        flag = false;
        //判断输入是否合法
        if (str == null || str.trim().equals("")) {
            flag = true;
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        // 先对符号位进行判断
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }

        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = true;
                return 0;
            }
            // 累加  用来判断是否发生溢出
            int sum = result * 10 + (int) (chars[i] - '0');

            // 判断是否溢出
            if((sum-(int) (chars[i] - '0')) / 10 != result){
                flag = true;
                return 0;
            }
            //　result累加
            result = result * 10 + (int) (chars[i] - '0');
            /*
             * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
             * 显然value>Integer.MAX_VALUE是不成立的
             */
        }
        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
        // 注意，当value=-2147483648时，value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int res = strToInt(str);
            System.out.println(res);
        }
    }
}
