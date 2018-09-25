package com.hayashi2026.leetcode.dfs

class `Word Break II` {

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in 1 until dp.size) {
            for (j in 0 until i) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        val set = hashSetOf<String>()
        val res = mutableListOf<String>()
        dfs(s, dp, set, wordDict, 0, mutableListOf(), res)
        return res
    }

    fun dfs(s: String, dp: BooleanArray, set: MutableSet<String>, wordDict: List<String>, start: Int, solution: MutableList<String>, res: MutableList<String>) {
        if (start == s.length) {
            res.add(solution.joinToString(" "))
            return
        }
        if (!dp[start]) return
        for (i in start until s.length) {
            val word = s.substring(start, i + 1)
            if (wordDict.contains(word) && !set.contains(word)) {
                solution.add(word)
                set.add(word)
                dfs(s, dp, set, wordDict, i + 1, solution, res)
                solution.removeAt(solution.lastIndex)
                set.remove(word)
            }
        }
    }

}


fun main(args: Array<String>) {
    val data = arrayListOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    val test = `Word Break II`()
    println(test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", data))
}