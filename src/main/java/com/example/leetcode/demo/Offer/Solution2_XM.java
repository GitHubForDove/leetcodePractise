package com.example.leetcode.demo.Offer;

import java.util.Scanner;
import java.util.Stack;

public class Solution2_XM {

    public static String getLeft(String s) {
        if(s.charAt(2) == ',')
            return null;
        if(s.charAt(3) == ',')
            return s.substring(2, 3);
        Stack<Character> stack = new Stack<Character>();
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    return s.substring(2, i+1);
                }
            }
        }
        return s.substring(2, s.indexOf(','));
    }

    public static String getRight(String s) {
        if(s.charAt(2) == ',')
            return s.substring(s.indexOf(',') + 1, s.length() - 1);
        if(s.charAt(3) == ',')
            return s.substring(s.indexOf(',') + 1, s.length() - 1);
        Stack<Character> stack = new Stack<Character>();
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    return s.substring(i + 2, s.length() - 1);
                }
            }
        }
        return s.substring(s.indexOf(',') + 1, s.length() - 1);
    }

    public static void Travese(String s) {
        if(s == null || s.equals("")) return;

        if(s.length() == 1) {
            System.out.print(s.charAt(0));
            return;
        }
        String left = getLeft(s);
        Travese(left);
        System.out.print(s.charAt(0));
        String right = getRight(s);
        Travese(right);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        Travese(_input);
        //res = solution(_input);
        //System.out.println(res);
    }
}


