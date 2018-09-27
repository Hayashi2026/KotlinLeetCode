package com.hayashi2026.leetcode.twopointers

import kotlin.math.min

class `Container With Most Water` {

    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size
        var max = 0
        while (start < end) {
            val capacity = (end - start) * min(height[start], height[end])
            if (capacity > max) max = capacity
            if (height[start] < height[end]) {
                start++
            } else {
                end--
            }
        }
        return max
    }

//    fun maxArea(height: IntArray): Int {
//        var max = 0
//        for (i in 0 until height.size - 1) {
//            for (j in i + 1 until height.size) {
//                val minimum = min(height[i], height[j])
//                val capacity = minimum * (j - i)
//                if (capacity > max) {
//                    max = capacity
//                }
//            }
//        }
//        return max
//    }
}