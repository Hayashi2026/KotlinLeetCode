package com.hayashi2026.leetcode.palindrome

class `Longest Palindromic Subsequence` {

    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length, { IntArray(s.length) })
        for (i in 0 until s.length) {
            var start = 0
            var end = start + i
            while (end < s.length) {
                if (start == end) {
                    dp[start][end] = 1
                } else if (start + 1 == end) {
                    dp[start][end] = if (s[start] == s[end]) 2 else 1
                } else {
                    if (s[start] == s[end]) {
                        dp[start][end] = dp[start + 1][end - 1] + 2
                    } else {
                        dp[start][end] = maxOf(dp[start + 1][end], dp[start][end - 1])
                    }
                }
                start++
                end++
            }
        }
        return dp[0][s.length - 1]
    }
}