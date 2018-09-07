package com.hayashi2026.leetcode.palindrome

class `Valid Palindrome` {

    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var start = 0
        var end = s.length - 1
        while (start < end) {
            if (!s[start].isLetterOrDigit()) {
                start++
                continue
            }
            if (!s[end].isLetterOrDigit()) {
                end--
                continue
            }
            if (s[start].toLowerCase() != s[end].toLowerCase()) {
                return false
            }
            start++
            end--
        }
        return true
    }
}

fun main(args: Array<String>) {
    val test = `Valid Palindrome`()
    println(test.isPalindrome("aa"))
}