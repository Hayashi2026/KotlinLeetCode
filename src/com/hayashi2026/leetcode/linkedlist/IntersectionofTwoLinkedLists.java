package com.hayashi2026.leetcode.linkedlist;

public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        ListNode tempA = headA;
        while (tempA.next != null) {
            tempA = tempA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode tempB = headB;
        while (tempB.next != null) {
            tempB = tempB.next;
            lenB++;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            if (lenA > lenB) headA = headA.next;
            if (lenB > lenA) headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
