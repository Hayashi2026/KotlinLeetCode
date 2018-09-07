package com.hayashi2026.leetcode.dp

class `Unique Paths II` {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rows = obstacleGrid.size
        val cols = obstacleGrid[0].size
        val dp = Array(rows, { IntArray(cols) })
        var obstacle = false
        for (i in 0 until cols) {
            if (obstacleGrid[0][i] == 1) obstacle = true
            if (obstacle) {
                dp[0][i] = 0
            } else {
                dp[0][i] = 1
            }
        }
        obstacle = false
        for (i in 0 until rows) {
            if (obstacleGrid[i][0] == 1) obstacle = true
            if (obstacle) {
                dp[i][0] = 0
            } else {
                dp[i][0] = 1
            }
        }
        for (i in 1 until rows) {
            for (j in 1 until cols) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                } else {
                    dp[i][j] = 0
                }
            }
        }
        return dp[rows - 1][cols - 1]
    }
}