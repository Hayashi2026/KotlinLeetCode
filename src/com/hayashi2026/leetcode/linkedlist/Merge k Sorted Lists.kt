package com.hayashi2026.leetcode.linkedlist

import java.util.*

class `Merge k Sorted Lists` {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val heap = PriorityQueue<ListNode>(lists.size, Comparator<ListNode> { o1, o2 -> o1!!.`val` - o2!!.`val` })
        for (node in lists) {
            node?.let {
                heap.add(node)
            }
        }
        val dummy = ListNode(0)
        var current: ListNode? = dummy
        while (!heap.isEmpty()) {
            val head = heap.poll()
            current?.next = head
            head.next?.let { heap.add(it) }
            current = current?.next
        }
        return dummy.next
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}