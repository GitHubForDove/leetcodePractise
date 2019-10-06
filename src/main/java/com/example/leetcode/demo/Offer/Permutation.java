package com.example.leetcode.demo.Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Permutation {



    public static HashSet<String> set = new HashSet<>();
    public static boolean[] step;
    public static char [] seqs;

    public static ArrayList<String> permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        seqs = new char[chars.length];
        step = new boolean[chars.length];
        dfs(0,chars);

        list.addAll(set);
        Collections.sort(list);

        return list;
    }

    /**
     *
     算法思路:

     1)n个元素的全排列=(n-1个元素的全排列)+(另一个元素作为前缀)

     2)出口:如果只有一个元素的全排列,则说明已经排完,则输出数组;

     3)不断将每个元素放左第一个元素,然后将它作为前缀,并将其余元素继续全排列
     * @param start
     * @param chars
     */
    public static void dfs(int start, char[] chars) {

        if (start == chars.length) {
            String str = new String(seqs);
            set.add(str);
            return; //返回上一步
        }

        for (int i=0; i<chars.length; i++) {

            if (!step[i]) {
                seqs[start] = chars[i];
                step[i] = true;
                dfs(i+1,chars);
                step[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> res = permutation(str);
        System.out.println(res);
    }
}
