package com.hayashi2026.leetcode.map

class `First Unique Character in a String` {

    fun firstUniqChar(s: String): Int {
        val map = IntArray(256)
        for (i in 0 until s.length) {
            map[s[i].toInt()]++
        }
        for (i in 0 until s.length) {
            if (map[s[i].toInt()] == 1) {
                return i
            }
        }
        return -1
    }
}