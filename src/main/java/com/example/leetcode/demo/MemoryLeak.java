package com.example.leetcode.demo;

import java.util.Vector;

public class MemoryLeak {


    public static void main(String[] args) {

        Vector v = new Vector();

        for (int i=0; i<Integer.MAX_VALUE; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
        System.out.println("结束了....");
    }
}
