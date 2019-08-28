package com.example.leetcode.demo.Offer;

import java.util.HashSet;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-08-28
 * @descript 删除链表中重复的节点
 */
public class DeleteDuplication {

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * 将链表中重复值的去重  保证链表中每个都是不重复的
     */
    public static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode p = pHead;
        ListNode pre = new ListNode(0);
        pre.next = p;
        HashSet set = new HashSet();
        while (p.next != null) {

            p = p.next;
            pre = pre.next;
            while (p != null && set.contains(p.val)) {
                p = p.next;
            }
            pre.next = p;
            if (p == null) {
                break;
            }
            set.add(p.val);

        }
        return pHead;
    }

    public static ListNode deleteDuplication2(ListNode pHead) {

        if (pHead == null || pHead.next==null) {
            return pHead;
        }

        ListNode Head = new ListNode(0);
        Head.next = pHead;

        ListNode pre  = Head;
        ListNode last = Head.next;

        while (last!=null){

            if(last.next != null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }

                pre.next = last.next;
                last = last.next;

            }else{

                pre = pre.next;
                last = last.next;

            }
        }
        return Head.next;
    }




    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next =  new ListNode(2);
        head.next.next =  new ListNode(2);
        head.next.next.next =  new ListNode(2);
        head.next.next.next.next =  new ListNode(2);
        head.next.next.next.next.next =  new ListNode(2);
        head.next.next.next.next.next.next =  new ListNode(5);

        ListNode res = deleteDuplication2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
