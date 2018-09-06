package com.hayashi2026.leetcode.dp

class `Decode Ways` {

    fun numDecodings(s: String): Int {
        if (s.isBlank()) {
            return 0
        }
        if (s.length == 1) {
            return if (isLegal(s[0])) 1 else 0
        }
        val dp = Array(s.length + 1, { 0 })
        dp[0] = 1
        dp[1] = if (isLegal(s[0])) 1 else 0
        for (i in 2..s.length) {
            var decodeWays = 0
            decodeWays += (if (isLegal(s[i - 1])) dp[i - 1] else 0)
            decodeWays += if (isLegal(s[i - 2], s[i - 1])) dp[i - 2] else 0
            dp[i] = decodeWays
        }
        return dp[s.length]
    }

    fun isLegal(tens: Char, units: Char): Boolean {
        if (tens == '0') {
            return false
        }
        if (tens == '1' || (tens <= '2' && units <= '6')) {
            return true
        }
        return false
    }

    fun isLegal(units: Char): Boolean {
        return units != '0'
    }
}

fun main(args: Array<String>) {
    val data = "17"
    val test = `Decode Ways`()
    println(test.numDecodings(data))
}