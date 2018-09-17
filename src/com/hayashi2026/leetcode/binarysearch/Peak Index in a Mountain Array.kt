package com.hayashi2026.leetcode.binarysearch

class `Peak Index in a Mountain Array` {

    fun peakIndexInMountainArray(A: IntArray): Int {
        var start = 0
        var end = A.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (A[mid] > A[mid - 1]) {
                start = mid
            } else {
                end = mid
            }
        }
        return if (A[start] > A[end]) start else end
    }
}