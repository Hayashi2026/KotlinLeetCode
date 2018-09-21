package com.hayashi2026.leetcode.tree

import java.lang.Math.abs
import java.util.*

class `Closest Binary Search Tree Value II` {

    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int> {
        val heap = PriorityQueue<Int>(Comparator<Int> { o1, o2 ->
            val diff1 = abs(o1 - target)
            val diff2 = abs(o2 - target)
            if (diff1 - diff2 < 0) {
                -1
            } else if (diff1 - diff2 > 0) {
                1
            } else {
                0
            }
        })
        traverse(root, heap)
        val result = arrayListOf<Int>()
        for (i in 0 until k) {
            result.add(heap.poll())
        }
        return result
    }

    fun traverse(root: TreeNode?, heap: PriorityQueue<Int>) {
        if (root == null) {
            return
        }
        traverse(root.left, heap)
        heap.add(root.`val`)
        traverse(root.right, heap)
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}