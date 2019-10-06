package com.example.leetcode.demo.Offer;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListPartition {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
    ******************************开始写代码******************************/
    public static ListNode partition(ListNode head,int m) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (cur != null) {
            if (cur.val <= m) {
                list1.add(cur.val);
            } else {
                list2.add(cur.val);
            }

            cur = cur.next;

        }
        ListNode res;
        if (list1.size() > 0) {
            res = new ListNode(list1.get(0));
            ListNode temp = res;
            for (int i=1; i<list1.size(); i++) {
                temp.next = new ListNode(list1.get(i));
                temp = temp.next;
            }

            for (int j=0; j<list2.size();j++) {
                temp.next = new ListNode(list2.get(j));
                temp = temp.next;
            }

        } else {
            res = new ListNode(list2.get(0));
            ListNode temp = res;
            for (int i=1; i<list2.size(); i++) {
                temp.next = new ListNode(list2.get(i));
                temp = temp.next;
            }
        }


        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        head = new ListNode(9);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);

        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}

