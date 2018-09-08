package com.hayashi2026.leetcode.palindrome

class `Longest Palindromic Substring` {

//    fun longestPalindrome(s: String): String {
//        var max = 0
//        var longestPalindrome = ""
//        for (i in 0 until s.length) {
//            for (j in i until s.length) {
//                if (isValid(s, i, j)) {
//                    if (j - i + 1 > max) {
//                        max = j - i + 1
//                        longestPalindrome = s.substring(i, j + 1)
//                    }
//                }
//            }
//        }
//        return longestPalindrome
//    }

    //动态规划
    fun longestPalindrome(s: String): String {
        val n = s.length
        var max = 0
        var longestPalindrome = ""
        val dp = Array(n, { BooleanArray(n) })
        for (i in 0 until s.length) {
            var start = 0
            var end = start + i
            while (end < s.length) {
                if (start == end) {
                    dp[start][end] = true
                } else if (start + 1 == end) {
                    dp[start][end] = (s[start] == s[end])
                } else {
                    dp[start][end] = (dp[start + 1][end - 1] && s[start] == s[end])
                }
                if (dp[start][end] && end - start + 1 > max) {
                    max = end - start + 1
                    longestPalindrome = s.substring(start, end + 1)
                }
                start++
                end++
            }
        }
        return longestPalindrome
    }

    fun isValid(s: String, i: Int, j: Int): Boolean {
        var start = i
        var end = j
        while (start < end) {
            if (s[start] != s[end]) {
                return false
            }
            start++
            end--
        }
        return true
    }
}

fun main(args: Array<String>) {
    val test = `Longest Palindromic Substring`()
    println(test.longestPalindrome("babad"))
}