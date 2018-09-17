package com.hayashi2026.leetcode.binarysearch

class `3Sum` {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 1) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var start = i + 1
            var end = nums.size - 1
            val target = -nums[i]
            nested@ while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++
                    continue@nested
                }
                if (end < nums.size - 2 && nums[end] == nums[end + 1]) {
                    end--
                    continue@nested
                }
                if (nums[start] + nums[end] > target) {
                    end--
                } else if (nums[start] + nums[end] < target) {
                    start++
                } else {
                    result.add(intArrayOf(nums[i], nums[start], nums[end]).toList())
                    start++
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(0, 0, 0, 0)
    val test = `3Sum`()
    println(test.threeSum(data))
}