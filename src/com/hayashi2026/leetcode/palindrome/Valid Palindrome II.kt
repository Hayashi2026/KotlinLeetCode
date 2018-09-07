package com.hayashi2026.leetcode.palindrome

class `Valid Palindrome II` {

    fun validPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }
        var start = 0
        var end = s.length - 1
        while (start < end) {
            if (s[start] != s[end]) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1)
            }
            start++
            end--
        }
        return true
    }

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        if (i > j) {
            return false
        }
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