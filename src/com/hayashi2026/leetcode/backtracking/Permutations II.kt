package com.hayashi2026.leetcode.backtracking

import java.util.*

class `Permutations II` {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        val book = BooleanArray(nums.size)
        dfs(nums, mutableListOf(), result, book)
        return result
    }

    fun dfs(nums: IntArray, solution: MutableList<Int>, result: MutableList<List<Int>>, book: BooleanArray) {
        if (solution.size == nums.size) {
            result.add(ArrayList<Int>(solution))
            return
        }
        for (i in 0 until nums.size) {
            if (!book[i]) {
                if (i > 0 && !book[i - 1] && nums[i] == nums[i - 1]) {
                    continue
                }
                solution.add(nums[i])
                book[i] = true
                dfs(nums, solution, result, book)
                solution.removeAt(solution.lastIndex)
                book[i] = false
            }
        }
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1, 1, 2)
    val test = `Permutations II`()
    println(test.permuteUnique(data))
}