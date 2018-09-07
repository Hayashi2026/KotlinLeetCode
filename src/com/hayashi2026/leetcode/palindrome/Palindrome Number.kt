package com.hayashi2026.leetcode.palindrome

import kotlin.math.abs

class `Palindrome Number` {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var y = 0
        var tmp = x
        while (tmp > 0) {
            val num = tmp % 10
            y = y * 10 + num
            tmp /= 10
        }
        return y == x
    }
}