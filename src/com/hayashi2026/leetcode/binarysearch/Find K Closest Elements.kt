package com.hayashi2026.leetcode.binarysearch

import java.lang.Math.abs

class `Find K Closest Elements` {

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val result = mutableListOf<Int>()
        val list = arr.toMutableList()
        for (i in 0 until k) {
            val index = binarySearch(list, x)
            result.add(list[index])
            list.removeAt(index)
        }
        return result.sorted()
    }

    fun binarySearch(arr: List<Int>, x: Int): Int {
        var start = 0
        var end = arr.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (arr[mid] > x) {
                end = mid
            } else if (arr[mid] < x) {
                start = mid
            } else {
                return mid
            }
        }
        if (abs(arr[start] - x) > abs(arr[end] - x)) {
            return end
        }
        return start
    }
}