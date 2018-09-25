package com.hayashi2026.leetcode.dfs

class `Permutation in String` {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val s1map = IntArray(26)
        val s2map = IntArray(26)
        for (i in 0 until s1.length) {
            s1map[s1[i] - 'a']++
            s2map[s2[i] - 'a']++
        }
        for (i in 0 until s2.length - s1.length + 1) {
            if (s1map.contentEquals(s2map)) return true
            s2map[s2[i] - 'a']--
            s2map[s2[s1.length + i] - 'a']++

        }
        return s1map.contentEquals(s2map)
    }

}

fun main(args: Array<String>) {
    val test = `Permutation in String`()
    println(test.checkInclusion("adc", "dcda"))
}