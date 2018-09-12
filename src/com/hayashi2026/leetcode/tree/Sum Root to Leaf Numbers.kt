package com.hayashi2026.leetcode.tree

class `Sum Root to Leaf Numbers` {

    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    fun dfs(node: TreeNode?, prev: Int): Int {
        if (node == null) {
            return 0
        }
        val sum = prev * 10 + node.`val`
        if (node.left == null && node.right == null) {
            return sum
        }
        return dfs(node.left, sum) + dfs(node.right, sum)
    }

//    fun sumNumbers(root: TreeNode?): Int {
//        if (root == null) return 0
//        val result = mutableListOf<Int>()
//        recurse(root, mutableListOf(), result)
//        return result.reduce { acc, i -> acc + i }
//    }
//
//    fun recurse(node: TreeNode?, solution: MutableList<Int>, result: MutableList<Int>) {
//        if (node == null) return
//        if (node.left == null && node.right == null) {
//            solution.add(node.`val`)
//            result.add(solution.reduce { acc, i -> acc * 10 + i })
//            solution.removeAt(solution.lastIndex)
//            return
//        }
//        solution.add(node.`val`)
//        recurse(node.left, solution, result)
//        recurse(node.right, solution, result)
//        solution.removeAt(solution.lastIndex)
//    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main(args: Array<String>) {
    val root = `Sum Root to Leaf Numbers`.TreeNode(1)
//    root.left = `Sum Root to Leaf Numbers`.TreeNode(2)
//    root.right = `Sum Root to Leaf Numbers`.TreeNode(3)
    val test = `Sum Root to Leaf Numbers`()
    println(test.sumNumbers(root))
}