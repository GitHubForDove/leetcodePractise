package com.example.leetcode.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class MemoryLeak {


    public static void main(String[] args) {

        /*Vector v = new Vector();

        for (int i=0; i<Integer.MAX_VALUE; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
        System.out.println("结束了....");*/

        List<String> res = new ArrayList<>();
        res.add("abc");
        res.add("def");
        res.add("jkl");
        res.add("abc");
        String[] strs = new String[]{"qqwe","asdad","abc","qwrw"};
        boolean flag = res.stream().anyMatch(s -> {
            boolean is = false;
            for (int i=0; i<strs.length; i++) {
                if (strs[i].equals(s)) {
                    is = true;
                    break;
                }
                System.out.println(strs[i]);
            }
            return is;
        });

        long count = res.stream().filter(s -> s.length() >= 2).count();
        System.out.println(count);

        String str = "qweqe,asd,ada,asd,asdasd,asd";
        List<String> words = Arrays.asList(str.split(","));
        count = words.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.charAt(0) == '-') {
                    return true;
                }
                return false;
            }
        }).count();
        System.out.println(count);
    }
}
