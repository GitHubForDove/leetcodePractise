package com.example.leetcode.demo.Offer;

import java.util.*;

public class Resolve_XC {

    public static String resolve(String expr) {

        if (expr.length() == 0) {
            return "";
        }

        if (!isMatch(expr)) {
            return "";
        }

        Stack stack = new Stack();
        Map<Character,Character> map  = new HashMap<>();
        map.put(')','(');
        String res = expr.substring(0,expr.indexOf("("));
        String tempStr = expr.substring(expr.indexOf("("), expr.lastIndexOf(")"));
        char[] chars = tempStr.toCharArray();
        for (int i=0; i<chars.length; i++) {
            ArrayList<Character> tempList = new ArrayList<>();
            if (map.containsKey(chars[i])) {
                boolean flag = true;
                while (flag) {
                    if (map.containsValue(stack.peek())) {
                        stack.pop();
                        flag = false;
                    } else {
                        tempList.add((Character) stack.pop());
                    }
                }
                for (char c :tempList) {
                    stack.push(c);
                }
            } else {
                stack.push(chars[i]);
            }
        }

        while (!stack.isEmpty()) {
            char c = (char) stack.pop();
            if (!(map.containsValue(c) || map.containsKey(c))) {
                res += c;
            }
        }
        res = res + expr.substring(expr.lastIndexOf(")")+1);
        return res;
    }


    public static  boolean isMatch(String s){
        Map<Character,Character> map  = new HashMap<>();
        map.put(')','(');

        Stack stack = new Stack();

        for(int i = 0; i < s.length(); i++){

            char temp = s.charAt(i);
            if(map.containsValue(temp)){
                stack.push(temp);
            }else if(map.containsKey(temp)){

                if(stack.isEmpty()){
                    return false;
                }

                if(stack.peek() == map.get(temp)){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
