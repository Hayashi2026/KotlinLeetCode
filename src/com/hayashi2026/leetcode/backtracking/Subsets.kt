package backtracking

import java.util.Arrays

class Subsets {

    fun subsets(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        dfs(nums, result, mutableListOf(), 0)
        return result
    }

    fun dfs(nums: IntArray, result: MutableList<List<Int>>, solution: MutableList<Int>, pos: Int) {
        val temp = mutableListOf<Int>()
        temp.addAll(solution)
        result.add(temp)

        for (i in pos until nums.size) {
            solution.add(nums[i])
            dfs(nums, result, solution, i + 1)
            solution.removeAt(solution.lastIndex)
        }
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1, 2, 3)
    val test = Subsets()
    test.subsets(data)
}
