package com.hayashi2026.leetcode.tree

import kotlin.math.max

class `Find Leaves of Binary Tree` {

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        getHeight(root, result)
        return result
    }

    fun getHeight(root: TreeNode?, result: MutableList<MutableList<Int>>): Int {
        if (root == null) {
            return 0
        }
        val left = getHeight(root.left, result)
        val right = getHeight(root.right, result)
        val height = max(left, right) + 1
        if (height > result.size) {
            result.add(mutableListOf())
        }
        result[height - 1].add(root.`val`)
        return height
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}