package com.hayashi2026.leetcode.backtracking

import java.util.*

class `Subsets II` {

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        val book = BooleanArray(nums.size)
        dfs(nums, 0, book, result, mutableListOf())
        return result
    }

    fun dfs(nums: IntArray, pos: Int, book: BooleanArray, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        result.add(ArrayList<Int>(solution))
        for (i in pos until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1] && !book[i - 1]) {
                continue
            }
            book[i] = true
            solution.add(nums[i])
            dfs(nums, i + 1, book, result, solution)
            solution.removeAt(solution.lastIndex)
            book[i] = false
        }
    }
}