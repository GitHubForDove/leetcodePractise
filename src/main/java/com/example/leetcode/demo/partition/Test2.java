package com.example.leetcode.demo.partition;

import java.util.*;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-29
 * @descript xx
 */
public class Test2 {

    public static void main(String[] args) {

        Map<String,String> res = new HashMap<>();
        res.put("a","a、");
        res.put("b","b、");
        res.put("c","c、");
        System.out.println(res);

        List<String[]> res2 = new ArrayList<>();
        res2.add(new String[]{"a","a"});
        res2.add(new String[]{"b","b"});
        res2.add(new String[]{"b","b"});

        System.out.println(Arrays.toString(res2.toArray()));

    }
}
