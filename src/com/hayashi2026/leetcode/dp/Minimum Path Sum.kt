package com.hayashi2026.leetcode.dp

class `Minimum Path Sum` {

    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }
        val dp = Array(grid.size, { IntArray(grid[0].size) })
        dp[0][0] = grid[0][0]
        for (i in 1 until grid.size) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        for (i in 1 until grid[0].size) {
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        }
        for (i in 1 until grid.size) {
            for (j in 1 until grid[0].size) {
                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
            }
        }
        return dp[dp.size - 1][dp[0].size - 1]
    }
}