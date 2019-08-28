package com.example.leetcode.demo.Offer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript 链表中环的入口节点
 */
public class EntryNodeOfLoop {


    /**
     * 题目描述
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        if (isContainCircle(pHead)) {
            return findEnter(pHead);
        }

        return null;
    }

    // 判断是否有环
    public static boolean isContainCircle(ListNode pHead) {
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }

        }

        return false;
    }

    public static ListNode findEnter(ListNode pHead) {
        ListNode p = pHead, p2 = pHead;

        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }

        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode q = pHead;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return q;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
    }
}
