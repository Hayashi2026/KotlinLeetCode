package com.hayashi2026.leetcode.dp

import kotlin.math.max

class `Maximum Subarray` {

    fun maxSubArray1(nums: IntArray): Int {
        var sum = nums[0]
        var maximum = nums[0]
        for (i in 1 until nums.size) {
            sum = if (sum > 0) sum + nums[i] else nums[i]
            maximum = max(sum, maximum)
        }
        return maximum
    }

    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var maximum = nums[0]
        for (i in 1 until nums.size) {
            dp[i] = if (dp[i - 1] > 0) dp[i - 1] + nums[i] else nums[i]
            maximum = max(dp[i], maximum)
        }
        return maximum
    }

//    fun maxSubArray(nums: IntArray): Int {
//        var max = Int.MIN_VALUE
//        for (i in 0 until nums.size) {
//            for (j in i until nums.size) {
//                var sum = 0
//                for (k in i..j) {
//                    sum += nums[k]
//                }
//                if (sum > max) max = sum
//            }
//        }
//        return max
//    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1)
    val test = `Maximum Subarray`()
    println(test.maxSubArray(data))
}