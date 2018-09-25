package com.hayashi2026.leetcode.array

class `Rotate Array` {

    fun rotate(nums: IntArray, k: Int): Unit {
        for (i in 0 until k) {
            rotateOne(nums)
        }
    }

    fun rotateOne(nums: IntArray) {
        val last = nums[nums.size - 1]
        for (i in nums.size - 2 downTo  0) {
            nums[i + 1] = nums[i]
        }
        nums[0] = last
    }
}