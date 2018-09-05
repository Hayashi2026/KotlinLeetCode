package com.hayashi2026.leetcode.dp

class `Unique Paths` {

    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 0) return n
        if (n == 0) return m
        val dp = Array(n, { IntArray(m) })
        for (i in 0 until n) {
            dp[i][0] = 1
        }
        for (i in 0 until m) {
            dp[0][i] = 1
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[0].size) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[n - 1][m - 1]
    }
}