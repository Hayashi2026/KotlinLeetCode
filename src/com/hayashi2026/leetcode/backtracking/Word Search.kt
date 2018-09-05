package com.hayashi2026.leetcode.backtracking

class `Word Search` {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val book = Array(board.size, { BooleanArray(board[0].size) })
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (dfs(board, word, 0, book, i, j)) {
                    return true
                }
            }
        }
        return false
    }

    fun dfs(board: Array<CharArray>, word: String, step: Int, book: Array<BooleanArray>, i: Int, j: Int): Boolean {
        if (step == word.length) {
            return true
        }
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || book[i][j] || word[step] != board[i][j]) {
            return false
        }
        book[i][j] = true
        val result = dfs(board, word, step + 1, book, i + 1, j)
                || dfs(board, word, step + 1, book, i - 1, j)
                || dfs(board, word, step + 1, book, i, j + 1)
                || dfs(board, word, step + 1, book, i, j - 1)
        book[i][j] = false
        return result
    }
}

fun main(args: Array<String>) {
    val board =
            arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
            )
    val test = `Word Search`()
    println(test.exist(board, "ABCCED"))
}