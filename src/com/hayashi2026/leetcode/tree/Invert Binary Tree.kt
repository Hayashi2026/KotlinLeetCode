package com.hayashi2026.leetcode.tree

class `Invert Binary Tree` {

    fun invertTree(root: TreeNode?): TreeNode? {
        dfs(root)
        return root
    }

    fun dfs(root: TreeNode?) {
        if (root == null || (root.left == null && root.right == null)) {
            return
        }
        val tmp = root.right
        root.right = root.left
        root.left = tmp
        dfs(root.left)
        dfs(root.right)
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}