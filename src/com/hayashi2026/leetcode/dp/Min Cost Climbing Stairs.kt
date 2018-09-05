package com.hayashi2026.leetcode.dp

import kotlin.math.min

class `Min Cost Climbing Stairs` {

    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size == 1) {
            return 0
        }
        val dp = IntArray(cost.size + 1)
        dp[0] = 0
        dp[1] = 0
        for (i in 2 until cost.size) {
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        }
        return dp[cost.size]
    }
}