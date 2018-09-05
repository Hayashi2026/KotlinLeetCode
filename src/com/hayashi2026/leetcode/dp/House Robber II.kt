package com.hayashi2026.leetcode.dp

class `House Robber II` {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }
        val res = IntArray(nums.size)
        res[0] = 0
        res[1] = nums[0]
        for (i in 2 until nums.size) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1])
        }

        val res1 = IntArray(nums.size)
        res1[0] = 0
        res1[1] = nums[1]
        for (i in 2 until nums.size) {
            res1[i] = Math.max(res1[i - 1], res1[i - 2] + nums[i])
        }

        return Math.max(res[res.lastIndex], res1[res1.lastIndex])
    }
}