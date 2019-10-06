package com.example.leetcode.demo.Tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question5 {


    public static int func(int[] a, int[] b){

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(a[0]);
        for (int i=1; i<a.length; i++) {
            if (list1.contains(a[i])) {
                list1.remove(list1.size()-1);
                continue;
            }
            list1.add(a[i]);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(b[0]);

        for (int i=1; i<b.length; i++) {
            if (list1.contains(b[i])) {
                list1.remove(list1.size()-1);
                continue;
            }
            list1.add(b[i]);
        }


        for (int i=0; i<list1.size(); i++) {
            for (int j=0; j<list2.size() ;j++) {
                list.add(list1.get(i) + list2.get(j));
            }
        }

        System.out.println(list);
        int res = 0;
        for (int num : list1) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i=0; i<n;i++) {
                a[i] = sc.nextInt();
            }

            for (int j=0; j<n;j++) {
                b[j] = sc.nextInt();
            }

            System.out.println(func(a, b));

        }
    }
}
