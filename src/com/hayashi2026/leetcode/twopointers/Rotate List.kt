package com.hayashi2026.leetcode.twopointers

class `Rotate List` {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) {
            return head
        }
        var cur = head
        var size = 0
        while (cur != null) {
            cur = cur.next
            size++
        }
        var shiftNum = k % size
        var slow = head
        var fast = head
        if (shiftNum == 0) return head
        while (shiftNum > 0) {
            fast = fast?.next
            shiftNum--
        }
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next
        }
        val newHead = slow?.next
        slow?.next = null
        fast?.next = head
        return newHead
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}

fun main(args: Array<String>) {
    val head = `Rotate List`.ListNode(1)
    head.next = `Rotate List`.ListNode(2)
//    head.next?.next = `Rotate List`.ListNode(3)
//    head.next?.next?.next = `Rotate List`.ListNode(4)
//    head.next?.next?.next?.next = `Rotate List`.ListNode(5)

    val test = `Rotate List`()
    test.rotateRight(head, 2)
}