import kotlin.math.max

class `Max Area of Island` {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var result = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    result = max(result, dfs(grid, i, j, 0))
                }
            }
        }
        return result
    }

    fun dfs(grid: Array<IntArray>, i: Int, j: Int, sum: Int): Int {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
            return 0
        }
        grid[i][j] = 0
        return 1 + dfs(grid, i + 1, j, sum + 1) +
                dfs(grid, i - 1, j, sum + 1) +
                dfs(grid, i, j + 1, sum + 1) +
                dfs(grid, i, j - 1, sum + 1)
    }
}

fun main(args: Array<String>) {
    val data = arrayOf(intArrayOf(0,1,0), intArrayOf(1,1,1))
    val test = `Max Area of Island`()
    println(test.maxAreaOfIsland(data))
}