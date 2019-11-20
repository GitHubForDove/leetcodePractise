package com.example.leetcode.demo.Leetcode;


/**
 * leetcode 876 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode_876 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len ++;
            p = p.next;
        }

        int k = len / 2;
        p = head;

        while (k > 0) {
            k--;
            p = p.next;
        }
        return p;
    }
}
