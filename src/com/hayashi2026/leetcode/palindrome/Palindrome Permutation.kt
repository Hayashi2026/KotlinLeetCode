package com.hayashi2026.leetcode.palindrome

class `Palindrome Permutation` {

    fun canPermutePalindrome(s: String): Boolean {
        val map = IntArray(256)
        for (i in 0 until s.length) {
            map[s[i].toInt()]++
        }
        var odd = 0
        for (i in 0 until map.size) {
            if (map[i] % 2 != 0) {
                odd++
            }
        }
        return odd <= 1
    }
}