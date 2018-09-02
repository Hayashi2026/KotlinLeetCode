package com.hayashi2026.leetcode.backtracking

class `Combination Sum III` {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        dfs(k, n, 1, result, mutableListOf())
        return result
    }

    fun dfs(k: Int, n: Int, pos:Int, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (n < 0) {
            return
        }
        if (solution.size == k) {
            if (n == 0) result.add(ArrayList<Int>(solution))
            return
        }
        for (i in pos..9) {
            solution.add(i)
            dfs(k, n - i, i + 1, result, solution)
            solution.removeAt(solution.lastIndex)
        }
    }
}