package com.hayashi2026.leetcode.dc

class `Majority Element` {

    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }
}