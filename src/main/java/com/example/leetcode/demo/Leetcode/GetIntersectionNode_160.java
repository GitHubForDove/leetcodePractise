package com.example.leetcode.demo.Leetcode;

import java.util.Stack;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode_160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用栈 来完成相交链表节点的确定
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (headA != null) {
            s1.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            s2.add(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!s1.empty() && !s2.empty()) {

            if (s1.peek() == s2.peek()) {
                res = s1.pop();
                s2.pop();
            } else {
               break;
            }
        }
        if (res != null) {
            return res;
        }
        return null;
    }

    /**
     * 第二种 解法 使用双指针
     * 思路：
     * 先算出连个链表的长度，然后将长的链表多出的那部分 减掉 然后指针一起向前遍历
     * 找到第一个相同的节点就是 相交链表的入口节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (headA != null || headB != null) {
            if (headA != null) {
                headA = headA.next;
                len1++;
            }

            if (headB != null) {
                headB = headB.next;
                len2 ++;
            }
        }

        int n = Math.abs(len1-len2);
        if (len1 >len2) {
            while (n>0) {
                p = p.next;
                n--;
            }
        } else {
            while (n>0) {
                q = q.next;
                n--;
            }
        }

        while (p != null && q != null) {
            if (p == q) {
                return p;
            }else {
                p = p.next;
                q = q.next;
            }
        }

        return null;
    }
}
