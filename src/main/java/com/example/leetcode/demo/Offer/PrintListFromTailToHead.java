package com.example.leetcode.demo.Offer;


import java.util.ArrayList;
import java.util.Collections;


/**
 * 从尾打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    public static class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ArrayList<Integer> res = printListFromTailToHead(head);
        System.out.println(res);
    }
}
