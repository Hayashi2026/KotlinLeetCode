package com.hayashi2026.leetcode.twopointers

class `Remove Linked List Elements` {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummyNode: ListNode? = ListNode(0)
        dummyNode!!.next = head
        var current = dummyNode
        while (current?.next != null) {
            if (current.next?.`val` == `val`) {
                current.next = current.next?.next
            } else {
                current = current.next
            }
        }
        return dummyNode.next
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}