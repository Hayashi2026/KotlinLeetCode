package com.hayashi2026.leetcode.tree
import com.hayashi2026.leetcode.tree.`Validate Binary Search Tree`.TreeNode as TreeNode

class `Validate Binary Search Tree` {

    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, null, null)
    }

    fun isValid(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) {
            return true
        }
        min?.let {
            if (root.`val` <= min) {
                return false
            }
        }
        max?.let {
            if (root.`val` >= max) {
                return false
            }
        }
        return isValid(root.left, min, root.`val`) && isValid(root.right, root.`val`, max)
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main(args: Array<String>) {
}