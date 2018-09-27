package com.hayashi2026.leetcode.slidingwindow

class `Maximum Average Subarray I` {

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var start = 0
        var end = 0
        var max = Int.MIN_VALUE.toDouble()
        var sum = 0
        while (end < nums.size) {
            sum += nums[end]
            if (start >= k) {
                sum -= nums[start - k]
            }
            if (end >= k - 1) {
                val average = sum.toDouble() / k
                if (average > max) {
                    max = average
                }
            }
            if (end > k - 1) {
                start++
                end++
            } else {
                end++
            }

        }
        return max
    }
}

fun main(args: Array<String>) {
    val test = `Maximum Average Subarray I`()
    println(test.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
}