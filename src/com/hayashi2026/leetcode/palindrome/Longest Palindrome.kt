package com.hayashi2026.leetcode.palindrome

class `Longest Palindrome` {

    fun longestPalindrome(s: String): Int {
        val map = IntArray(256)
        for (i in 0 until s.length) {
            map[s[i].toInt()]++
        }
        var res = 0
        var odd = 0
        for (i in 0 until map.size ){
            if (map[i] % 2 == 0) {
                res += map[i]
            } else {
                odd++
                res += map[i] - 1
            }
        }
        if (odd > 0) {
            return res + 1
        }
        return res
    }
}