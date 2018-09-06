package com.hayashi2026.leetcode.dp

class `Stone Game` {

    fun stoneGame(piles: IntArray): Boolean {
        val n = piles.size
        val dp = Array(n, { IntArray(n) })
        for (i in 0 until n) {
            dp[i][i] = piles[i]
        }
        for (l in 1 until n) {
            for (i in 0 until n - l) {
                val j = i + l
                dp[i][j] = maxOf(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
            }
        }
        return dp[0][n - 1] > 0
    }
}