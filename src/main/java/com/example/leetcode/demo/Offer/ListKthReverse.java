package com.example.leetcode.demo.Offer;


import java.util.Stack;

/**
 * 每K个节点进行反转
 */
public class ListKthReverse {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public static ListNode reverseKGroup(ListNode head, int k) {

        int size=0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode p = pre;

        // 先计算整个链表的长度
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int count = size / k;
        int len = count * k;

        if (head == null ) return null;
        // 首先派出 不满k的情况
        if (head.next == null || count == 0 || k == 1) return head;

        // 使用栈 来存储node节点 后面用来做翻转时 使用
        Stack<ListNode> stack = new Stack<>();

        // 标志 是否满足翻转的条件
        int flag = 1;

        while (len >= 0) {

            if (flag % (k+1) == 0) {
                // 停下来 先进行翻转
                while (stack.size() > 0) {
                    ListNode temp = stack.pop();
                    temp.next = null;
                    pre.next = temp;
                    pre = pre.next;
                }
                pre.next = head;
                if (head == null) return p.next;
                flag = 1;

            } else {
                // 指针向前走
                stack.add(head);
                head = head.next;
                flag ++;
                len --;
            }

        }

        return p.next;
    }
}
