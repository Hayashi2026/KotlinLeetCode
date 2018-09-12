package com.hayashi2026.leetcode.linkedlist

class `Reverse Linked List II` {

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val dummy: ListNode? = ListNode(0)
        dummy?.next = head
        var pre = dummy
        for (i in 0 until m - 1) pre = pre?.next
        var start = pre?.next
        var then = start?.next
        for (i in 0 until n - m) {
            val tmp = then?.next
            then?.next = start
            start?.next = tmp
            pre?.next = then
            then = tmp
        }
        return dummy?.next
    }
}

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val test = `Reverse Linked List II`()
    test.reverseBetween(node1, 2, 4)

}