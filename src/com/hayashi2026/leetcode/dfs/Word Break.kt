package com.hayashi2026.leetcode.dfs

class `Word Break` {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in 1 until dp.size) {
            var res = false
            for (j in 0 until i) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    res = true
                }
            }
            dp[i] = res
        }
        return dp[s.length]
    }


}