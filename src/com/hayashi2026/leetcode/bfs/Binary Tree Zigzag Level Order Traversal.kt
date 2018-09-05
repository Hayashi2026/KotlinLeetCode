package com.hayashi2026.leetcode.bfs

import java.util.*

class `Binary Tree Zigzag Level Order Traversal` {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        var isReverse = true
        val queue = LinkedList<TreeNode>()
        root?.let { queue.add(it) }
        val result = mutableListOf<List<Int>>()
        while (!queue.isEmpty()) {
            val level = mutableListOf<Int>()
            val size = queue.size
            for (i in 0 until size) {
                val head = queue.poll()
                if (isReverse) {
                    level.add(head.`val`)
                } else {
                    level.add(0, head.`val`)
                }
                head.left?.let { queue.offer(it) }
                head.right?.let { queue.offer(it) }
            }
            result.add(level)
            isReverse = !isReverse
        }
        return result
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}