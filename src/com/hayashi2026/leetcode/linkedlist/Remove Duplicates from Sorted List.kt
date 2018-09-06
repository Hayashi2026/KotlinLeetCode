package com.hayashi2026.leetcode.linkedlist

class `Remove Duplicates from Sorted List` {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        while (cur?.next != null) {
            if (cur.`val` == cur.next?.`val`) {
                cur.next = cur.next?.next
            } else {
                cur = cur.next
            }
        }
        return head
    }
}