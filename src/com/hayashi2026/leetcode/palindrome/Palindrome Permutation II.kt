package com.hayashi2026.leetcode.palindrome

class `Palindrome Permutation II` {

    fun generatePalindromes(s: String): List<String> {
        val result = mutableListOf<String>()
        if (s.length == 1) {
            result.add(s)
            return result
        }
        val map = IntArray(256)
        for (i in 0 until s.length) {
            map[s[i].toInt()]++
        }
        val chars = mutableListOf<Char>()
        var oddStr = ""
        var odds = 0
        for (i in 0 until map.size) {
            if (map[i] == 0) continue
            if (map[i] % 2 != 0) {
                oddStr = i.toChar().toString()
                odds++
            }
            for (j in 0 until map[i] / 2) {
                chars.add(i.toChar())
            }
        }
        if (odds > 1) return result
        permutation(chars.joinToString(""), oddStr, mutableSetOf(), mutableListOf(), result)
        return result
    }

    fun permutation(s: String, mid: String, set: MutableSet<Int>, solution: MutableList<Char>, result: MutableList<String>) {
        if (solution.size == s.length) {
            val str = solution.joinToString("")
            result.add("$str$mid${str.reversed()}")
            return
        }
        for (i in 0 until s.length) {
            if (!set.contains(i)) {
                if (i > 0 && !set.contains(i - 1) && s[i] == s[i - 1]) {
                    continue
                }
                solution.add(s[i])
                set.add(i)
                permutation(s, mid, set, solution, result)
                solution.removeAt(solution.lastIndex)
                set.remove(i)
            }
        }
    }
}

fun main(args: Array<String>) {
    val test = `Palindrome Permutation II`()
    println(test.generatePalindromes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
}