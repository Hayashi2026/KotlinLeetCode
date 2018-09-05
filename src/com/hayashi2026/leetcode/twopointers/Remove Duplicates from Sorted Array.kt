package com.hayashi2026.leetcode.twopointers

class `Remove Duplicates from Sorted Array` {

    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 0
        for (i in 1 until nums.size) {
            if (nums[i] != nums[pointer]) {
                nums[++pointer] = nums[i]
            }
        }
        return pointer + 1
    }
}