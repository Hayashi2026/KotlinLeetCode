package com.hayashi2026.leetcode.dfs

class `Palindrome Partitioning` {

    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        dfs(s, 0, arrayListOf(), result)
        return result
    }

    fun dfs(s: String, start: Int, solution: MutableList<String>, result: MutableList<List<String>>) {
        if (start == s.length) {
            result.add(ArrayList(solution))
            return
        }
        for (i in start until s.length) {
            if (isPalindrome(s.substring(start, i + 1))) {
                solution.add(s.substring(start, i + 1))
                dfs(s, i + 1, solution, result)
                solution.removeAt(solution.lastIndex)
            }
        }
    }

    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1
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
    val test = `Palindrome Partitioning`()
    println(test.partition("aab"))
}