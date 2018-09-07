package com.hayashi2026.leetcode.linkedlist

class `Reverse Linked List` {

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
        }
        return pre
    }

//    fun reverseList(head: ListNode?): ListNode? {
//        if (head?.next == null) return head
//        var pre = head
//        var cur = head.next
//        var next = head.next?.next
//        pre.next = null
//        while (cur != null) {
//            cur.next = pre
//            pre = cur
//            cur = next
//            next = cur?.next
//        }
//        return pre
//    }
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

    val test = `Reverse Linked List`()
    test.reverseList(node1)

}