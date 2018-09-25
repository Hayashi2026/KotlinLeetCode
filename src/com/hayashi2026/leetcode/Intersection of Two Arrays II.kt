package com.hayashi2026.leetcode

class `Intersection of Two Arrays II` {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums1) {
            if (map[i] != null) {
                val count = map[i]
                map[i] = count!! + 1
            } else {
                map[i] = 1
            }
        }
        val res = mutableListOf<Int>()
        for (i in nums2) {
            if (map[i] != null && map[i]!! > 0) {
                res.add(i)
                val count = map[i]
                map[i] = count!! - 1
            }
        }
        return res.toIntArray()
    }
}