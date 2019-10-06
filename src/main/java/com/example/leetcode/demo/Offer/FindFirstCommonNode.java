package com.example.leetcode.demo.Offer;

public class FindFirstCommonNode {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int lengthList1 = 0;
        int lengthList2 = 0;
        ListNode p = pHead1;
        ListNode q = pHead2;
        while (p != null) {
            p = p.next;
            lengthList1++;
        }

        while (q != null) {
            q = q.next;
            lengthList2++;
        }

        int step = 0;
        p = pHead1;
        q = pHead2;
        if (lengthList1 >= lengthList2) {
            step = lengthList1 - lengthList2;

            while (step > 0) {
                p = p.next;
                step--;
            }

            while (p != null && q != null) {
                if (p.val == q.val) {
                    return p;
                }
                p = p.next;
                q = q.next;
            }

        } else {
            step = lengthList2 - lengthList1;

            while (step > 0) {
                q = q.next;
                step--;
            }

            while (p != null && q != null) {
                if (p.val == q.val) {
                    return p;
                }
                p = p.next;
                q = q.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
