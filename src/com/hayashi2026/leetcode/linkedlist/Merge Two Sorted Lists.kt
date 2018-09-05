package com.hayashi2026.leetcode.linkedlist

class `Merge Two Sorted Lists` {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var head: ListNode? = dummy
        var left = l1
        var right = l2
        while (left != null && right != null) {
            if (left.`val` < right.`val`) {
                head?.next = left
                left = left.next
            } else {
                head?.next = right
                right = right.next
            }
            head = head?.next
        }
        if (left != null) {
            head?.next = left
        }
        if (right != null) {
            head?.next = right
        }
        return dummy.next
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
    override fun toString(): String {
        return `val`.toString()
    }
}

fun main(args: Array<String>) {
    val test = `Merge Two Sorted Lists`()
    println(test.mergeTwoLists(ListNode(2), ListNode(1)))
}