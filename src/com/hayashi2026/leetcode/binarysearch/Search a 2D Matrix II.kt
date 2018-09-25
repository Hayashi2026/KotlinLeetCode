package com.hayashi2026.leetcode.binarysearch

class `Search a 2D Matrix II` {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var x = matrix.size - 1
        var y = 0
        while (x >= 0 && y < matrix[0].size) {
            if (matrix[x][y] > target) {
                x--
            } else if (matrix[x][y] < target) {
                y++
            } else {
                return true
            }
        }
        return false
    }

//    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
//        for (i in matrix) {
//            if (binarySearch(i, target)) return true
//        }
//        return false
//    }
//
//    fun binarySearch(array: IntArray, target: Int): Boolean {
//        var start = 0
//        var end = array.size - 1
//        while (start + 1 < end) {
//            val middle = start + (end - start) / 2
//            if (array[middle] > target) {
//                end = middle - 1
//            } else if (array[middle] < target) {
//                start = middle + 1
//            } else {
//                return true
//            }
//        }
//        if (array[start] == target) {
//            return true
//        }
//        if (array[end] == target) {
//            return true
//        }
//        return false
//    }
}