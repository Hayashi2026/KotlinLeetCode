package com.hayashi2026.leetcode.dp

import kotlin.comparisons.*
class `Maximal Square` {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) {
            return 0
        }
        val result = Array(matrix.size, { IntArray(matrix[0].size) })
        var max = 0
        for (i in 0 until matrix.size) {
            result[i][0] = if (matrix[i][0] == '1') 1 else 0
            max = maxOf(result[i][0], max)
        }
        for (j in 0 until matrix[0].size) {
            result[0][j] = if (matrix[0][j] == '1') 1 else 0
            max = maxOf(result[0][j], max)
        }
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == '1') {
                    result[i][j] = minOf(result[i - 1][j - 1], result[i - 1][j], result[i][j - 1]) + 1
                }
                if (result[i][j] > max) {
                    max = result[i][j]
                }
            }
        }
        return max * max
    }
}

fun main(args: Array<String>) {
    val data = arrayOf(charArrayOf('1'))
    val test = `Maximal Square`()
    println(test.maximalSquare(data))
}