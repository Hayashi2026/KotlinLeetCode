package com.hayashi2026.leetcode.backtracking

class Combinations {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        dfs(n, k, 1, result, mutableListOf())
        return result
    }

    fun dfs(n: Int, k: Int, pos: Int, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (solution.size == k) {
            result.add(ArrayList<Int>(solution))
            return
        }
        for (i in pos..n) {
            solution.add(i)
            dfs(n, k, i + 1, result, solution)
            solution.removeAt(solution.lastIndex)
        }
    }
}