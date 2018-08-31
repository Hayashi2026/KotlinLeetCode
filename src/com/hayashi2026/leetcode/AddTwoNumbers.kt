/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var isRound = false
        val root = ListNode(0)
        var currentNode = root
        var leftNode = l1
        var rightNode = l2
        while (leftNode != null || rightNode != null) {
            val leftNum = leftNode?.`val` ?: 0
            val rightNum = rightNode?.`val` ?: 0
            val sum = leftNum + rightNum + (if (isRound) 1 else 0)
            isRound = sum > 9
            currentNode.next = ListNode(sum % 10)
            currentNode = currentNode.next!!
            leftNode = leftNode?.next
            rightNode = rightNode?.next
        }
        if (isRound) {
            currentNode.next = ListNode(1)
        }
        return root.next
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}