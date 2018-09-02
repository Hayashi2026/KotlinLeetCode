package com.hayashi2026.leetcode.backtracking

class `Combination Sum IV` {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val result = mutableListOf<List<Int>>()
        dfs(nums, target, result, mutableListOf())
        return result.size
    }

    fun dfs(nums: IntArray, target: Int, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.add(ArrayList<Int>(solution))
            return
        }
        for (i in 0 until nums.size) {
            solution.add(nums[i])
            dfs(nums, target - nums[i], result, solution)
            solution.removeAt(solution.lastIndex)
        }
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(4, 2, 1)
    val test = `Combination Sum IV`()
    println(test.combinationSum4(data, 32))
}