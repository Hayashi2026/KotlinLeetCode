package com.hayashi2026.leetcode.tree

class `Kth Smallest Element in a BST` {

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val result = mutableListOf<Int>()
        dfs(root, result)
        return result[k - 1]
    }

    fun dfs(root: TreeNode?, result: MutableList<Int>) {
        if (root == null) {
            return
        }
        dfs(root.left, result)
        result.add(root.`val`)
        dfs(root.right, result)
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}