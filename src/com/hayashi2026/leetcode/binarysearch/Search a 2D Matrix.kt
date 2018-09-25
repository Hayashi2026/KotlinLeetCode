package com.hayashi2026.leetcode.binarysearch

class `Search a 2D Matrix` {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        val m = matrix.size
        val n = matrix[0].size
        val size = m * n
        var start = 0
        var end = size - 1
        while (start + 1 < end) {
            val middle = start + (end - start) / 2
            val row = middle / n
            val column = middle % n
            if (matrix[row][column] > target) {
                end = middle - 1
            } else if (matrix[row][column] < target) {
                start = middle + 1
            } else {
                return true
            }
        }
        if (matrix[start / n][start % n] == target) {
            return true
        }
        if (matrix[end / n][end % n] == target) {
            return true
        }
        return false
    }
}