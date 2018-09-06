package com.hayashi2026.leetcode.linkedlist

class `Remove Duplicates from Sorted List II` {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy: ListNode? = ListNode(0)
        dummy?.next = head
        var pre = dummy
        var cur = dummy?.next
        while (cur?.next != null) {
            if (cur.`val` == cur.next?.`val`) {
                while (cur.next != null && cur.`val` == cur.next?.`val`) {
                    cur.next = cur.next?.next
                }
                pre?.next = cur.next
                cur = pre?.next
            } else {
                pre = pre?.next
                cur = cur.next
            }
        }
        return dummy?.next
    }
}