package com.hayashi2026.leetcode.dp

class `Longest Continuous Increasing Subsequence` {

    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = IntArray(nums.size)
        dp[0] = 1
        var max = dp[0]
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1
            } else {
                dp[i] = 1
            }
            max = maxOf(dp[i], max)
        }
        return max
    }
}