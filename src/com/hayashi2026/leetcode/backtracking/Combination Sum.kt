package backtracking

import java.util.*

class `Combination Sum` {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val result = mutableListOf<List<Int>>()
        dfs(candidates, mutableListOf(), result, target, 0)
        return result
    }

    fun dfs(candidates: IntArray, solution: MutableList<Int>, result: MutableList<List<Int>>, target: Int, pos: Int) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.add(ArrayList<Int>(solution))
            return
        }
        for (i in pos until candidates.size) {
            solution.add(candidates[i])
            dfs(candidates, solution, result, target - candidates[i], i)
            solution.removeAt(solution.lastIndex)
        }
    }
}