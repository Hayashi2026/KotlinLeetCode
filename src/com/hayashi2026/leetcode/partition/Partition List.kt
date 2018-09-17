package com.hayashi2026.leetcode.partition

class `Partition List` {

    fun partition(head: ListNode?, x: Int): ListNode? {
        val leftDummy: ListNode? = ListNode(0)
        val rightDummy: ListNode? = ListNode(0)
        var cur = head
        var left = leftDummy
        var right = rightDummy
        while (cur != null) {
            if (cur.`val` < x) {
                left?.next = cur
                left = left?.next
            } else {
                right?.next = cur
                right = right?.next
            }
            cur = cur.next
        }
        left?.next = null
        right?.next = null
        left?.next = rightDummy?.next
        if (leftDummy?.next == null) {
            return rightDummy?.next
        }
        return leftDummy.next
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}