package com.hayashi2026.leetcode.palindrome

class `Palindromic Substrings` {

    fun countSubstrings(s: String): Int {
        val dp = Array(s.length, { BooleanArray(s.length) })
        var res = 0
        for (i in 0 until s.length) {
            var start = 0
            var end = start + i
            while (end < s.length) {
                if (start == end) {
                    dp[start][end] = true
                } else if (start + 1 == end) {
                    dp[start][end] = s[start] == s[end]
                } else {
                    dp[start][end] = dp[start + 1][end - 1] && s[start] == s[end]
                }
                if (dp[start][end]) {
                    res++
                }
                start++
                end++
            }
        }
        return res
    }
}