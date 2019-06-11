package com.example.leetcode.demo.partition;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying
 * @created 2019-06-10
 * @descript 给表达式加括号  leetcode 241. Different Ways to Add Parentheses (Medium)
 */
public class DiffWaysToCompute {

    public static void main(String[] args) {
        String input = "2-1-1";

       // System.out.println(input);
        List<Integer> result = diffWaysToCompute(input);
        System.out.println(result);
    }

    public static List<Integer> diffWaysToCompute(String input) {

        // 用于记录不同组合的结果
        List<Integer> ways = new ArrayList<>();

        for (int i=0; i<input.length();i++) {
            char c = input.charAt(i);

            if (c =='+' || c =='-' || c == '*') {

                // 将符号等运算符的左右两边 再进行划分，再将划分好的左右两边分别进行递归调用
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            // 如果是+  那么就将左边加上右边
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        // 当没有字符可以为 - + * 中的一种的时候 说明字符串中没有运算进行  所以直接将整个字符串进行返回
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }

        return ways;
    }



    }
