package com.hayashi2026.leetcode.tree

import java.util.*

class `Count Complete Tree Nodes` {

    fun countNodes(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }
        var count = 0
        while (!queue.isEmpty()) {
            val head = queue.pop()
            head.left?.let { queue.offer(it) }
            head.right?.let { queue.offer(it) }
            count++
        }
        return count
    }

    inner class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}