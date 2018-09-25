package com.hayashi2026.leetcode.linkedlist;

import java.util.HashMap;

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while (head != null) {
            cur.next = new RandomListNode(head.label);
            cur.next.random = head.random;
            map.put(head, cur.next);
            cur = cur.next;
            head = head.next;
        }
        cur = dummy.next;
        while (cur != null) {
            RandomListNode random = cur.random;
            cur.random = map.get(random);
            cur = cur.next;
        }
        return dummy.next;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
