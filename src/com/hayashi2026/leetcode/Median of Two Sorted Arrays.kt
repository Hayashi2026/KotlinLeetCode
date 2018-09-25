package com.hayashi2026.leetcode

import kotlin.math.min

class `Median of Two Sorted Arrays` {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val length = nums1.size + nums2.size
        if (length % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, length / 2).toDouble() + findKth(nums1, nums2, 0, 0, length / 2 + 1).toDouble()) / 2
        }
        return findKth(nums1, nums2, 0, 0, length / 2 + 1).toDouble()
    }

    fun findKth(nums1: IntArray, nums2: IntArray, start1: Int, start2: Int, k: Int): Int {
        if (start1 >= nums1.size) {
            return nums2[start2 + k - 1]
        }
        if (start2 >= nums2.size) {
            return nums1[start1 + k - 1]
        }
        if (k == 1) {
            return min(nums1[start1], nums2[start2])
        }
        val middle1 = if (start1 + k / 2 - 1 < nums1.size) nums1[start1 + k / 2 - 1] else Int.MAX_VALUE
        val middle2 = if (start2 + k / 2 - 1 < nums2.size) nums2[start2 + k / 2 - 1] else Int.MAX_VALUE
        if (middle1 < middle2) {
            return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2)
        }
        return findKth(nums1, nums2, start1, start2 + k / 2, k  - k / 2)
    }

}

fun main(args: Array<String>) {
    val test = `Median of Two Sorted Arrays`()
    println(test.findMedianSortedArrays(intArrayOf(3), intArrayOf(-2, -1)))
}