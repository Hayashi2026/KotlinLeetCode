package com.hayashi2026.leetcode.palindrome

class `Palindrome Linked List` {

    fun isPalindrome(head: ListNode?): Boolean {
        val middleNode = findMiddle(head)
        var head = head
        var tail = reverse(middleNode)

        while (tail != null) {
            if (tail.`val` != head?.`val`) {
                return false
            }
            head = head.next
            tail = tail.next
        }
        return true
    }

    fun findMiddle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun reverse(head: ListNode?): ListNode? {
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
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node2
    val test = `Palindrome Linked List`()
    println(test.isPalindrome(node1))
}