package com.hayashi2026.leetcode

class `Intersection of Two Arrays` {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set = nums1.toSet()
        val res = mutableListOf<Int>()
        for (i in nums2) {
            if (set.contains(i) && !res.contains(i)) {
                res.add(i)
            }
        }
        return res.toIntArray()
    }
}