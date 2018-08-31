package backtracking

class Permutations {

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val book = BooleanArray(nums.size)
        dfs(nums, book, result, mutableListOf())
        return result
    }

    fun dfs(nums: IntArray, book: BooleanArray, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (solution.size == nums.size) {
            val temp = mutableListOf<Int>()
            temp.addAll(solution)
            result.add(temp)
            return
        }
        for (i in 0 until nums.size) {
            if (!book[i]) {
                book[i] = true
                solution.add(nums[i])
                dfs(nums, book, result, solution)
                solution.removeAt(solution.lastIndex)
                book[i] = false
            }
        }
    }
}