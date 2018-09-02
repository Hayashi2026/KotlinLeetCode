package com.hayashi2026.leetcode.backtracking

import java.util.*

class `Combination Sum II` {

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val result = mutableListOf<List<Int>>()
        dfs(candidates, target, 0, result, mutableListOf())
        return result
    }

    fun dfs(candidates: IntArray, target: Int, pos: Int, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.add(ArrayList<Int>(solution))
            return
        }
        for (i in pos until candidates.size) {
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            solution.add(candidates[i])
            dfs(candidates, target - candidates[i], i + 1, result, solution)
            solution.removeAt(solution.lastIndex)
        }
    }
}