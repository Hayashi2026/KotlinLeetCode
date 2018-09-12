package com.hayashi2026.leetcode.twopointers

class `Implement strStr()` {

    fun strStr(haystack: String, needle: String): Int {
        if (needle == "") return 0
        if (needle.length > haystack.length) return -1
        var start = 0
        while (start <= haystack.length - needle.length) {
            loop@ for (i in 0 until needle.length) {
                if (haystack[start + i] != needle[i]) {
                    break@loop
                }
                if (i == needle.length - 1) {
                    return start
                }
            }
            start++
        }
        return -1
    }
}