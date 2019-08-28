package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript 表示数值的字符串
 */
public class IsNumeric {

    /**
     * 题目描述
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */

    /**
     *
     * 1、字符为 e 或者 E 时： 1）e后面一定要接数字，没有接数字为不正确的数字
     *                      2）不能存在有那个e的情况
     *
     * 2、当字符为 + 或者 - 时：1）如果出现的位置不是首位，那么只能出现在e的后面 如果出现在其他位置 直接返回false
     *                       2）第二次只能在 e 后面
     *
     * 3、当字符为 . 时： 1）e后面不能为小数
     *                  2）小数点后面  只能为数字
     *
     */

    public static boolean isNumeric(char[] str) {

        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;

        for (int i = 0; i < str.length; i++) {

            if (str[i] == 'e' || str[i] == 'E') {

                if (i == str.length-1) {
                    return false; // e后面一定要接数字,如果e后面没有数字，就说明不是正确的数字
                }
                if (hasE) {
                    return false;  // 不能同时存在两个e,
                }
                hasE = true;

            } else if (str[i] == '+' || str[i] == '-') {

                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                sign = true;

            } else if (str[i] == '.') {

                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }

                decimal = true;

            } else if (str[i] < '0' || str[i] > '9') {// 不合法字符
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "-1E-16";
        char[] c = str.toCharArray();
        System.out.println(isNumeric(c));
    }
}
