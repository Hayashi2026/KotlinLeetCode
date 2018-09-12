package com.hayashi2026.leetcode.linkedlist

class `Middle of the Linked List` {

    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next
        while (fast != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
}