package com.example.leetcode.demo.Offer.Stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对于给定的K(K>0),逆置表中包含K个节点的块。
 */
public class ReverseBlockOfKnodesInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 分析：
     * 1、检查链表当前的剩余部分是否存在K个节点
     *   a、如果有，那么获取（链表当前剩余部分）第K+1个节点的指针
     *   b、如果没有，则返回
     * 2、逆转前面的K个节点
     * 3、K个节点逆置后，设置其中最后一个节点的后继指针指向第K+1个节点
     * 4、移动到第K+1个节点
     * 5、跳转到步骤1
     * 6、如果执行了逆置操作，那么第一个块的k-1个节点成为新的表头节点，否则返回原表头节点。
     */
    public static ListNode reverseBlockOfKnodesInLinkedList(ListNode head, int K) {
        ListNode temp, next, cur = head,newHead;
        if (K==0 || K==1) {
            return head;
        }

        if (hasKnodes(cur, K-1)) {
            newHead = getKPlusKOneThNode(K-1, cur);
        } else {
            newHead = head;
        }

        while (cur!=null && hasKnodes(cur, K)) {
            temp = getKPlusKOneThNode(K, cur);
            int i=0;
            while (i<K) {
                next = cur.next;
                cur.next = temp;
                temp = cur;
                cur = next;
                i++;
            }
        }

        return newHead;
    }

    public static boolean hasKnodes(ListNode head, int K) {

        for (int i=0; i<K;i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 获取第K
     */
    public static ListNode getKPlusKOneThNode(int K, ListNode head) {
        ListNode kth = head;
        if (head == null) return head;
        for (int i=0; i<K;i++) {
            if (kth == null) {
                return head.next;
            }
            kth=kth.next;
        }
        return kth;
    }


    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //List list = new ArrayList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode newHead = reverseBlockOfKnodesInLinkedList(head, 3);
        while (newHead!= null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}
