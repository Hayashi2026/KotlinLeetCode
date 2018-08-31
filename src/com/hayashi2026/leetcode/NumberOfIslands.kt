class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j)
                    result++
                }
            }
        }
        return result
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || grid[i][j] != '1') {
            return
        }
        grid[i][j] = '0'
        dfs(grid, i - 1, j)
        dfs(grid, i + 1, j)
        dfs(grid, i, j - 1)
        dfs(grid, i, j + 1)
    }
}