package com.hayashi2026.leetcode.dp

import kotlin.math.max

class `Maximum Product Subarray` {

    fun maxProduct(nums: IntArray): Int {
        var result = nums[0]
        val dpMin = Array(nums.size, { 0 })
        val dpMax = Array(nums.size, { 0 })
        dpMin[0] = nums[0]
        dpMax[0] = nums[0]
        for (i in 1 until nums.size) {
            dpMin[i] = minOf(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i])
            dpMax[i] = maxOf(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i])
            result = max(result, dpMax[i])
        }
        return result
    }
}