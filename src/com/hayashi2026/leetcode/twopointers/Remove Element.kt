package com.hayashi2026.leetcode.twopointers

class `Remove Element` {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                swap(index, i, nums)
                index++
            }
        }
        return index
    }

    fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp
    }
}