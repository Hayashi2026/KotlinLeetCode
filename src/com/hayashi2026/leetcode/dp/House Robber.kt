package com.hayashi2026.leetcode.dp

class `House Robber` {

    fun rob(nums: IntArray): Int {
        val res = IntArray(nums.size)
        res[0] = nums[0]
        res[1] = Math.max(nums[0], nums[1])
        for (i in 2 until nums.size) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i])
        }
        return res[nums.size - 1]
    }
}