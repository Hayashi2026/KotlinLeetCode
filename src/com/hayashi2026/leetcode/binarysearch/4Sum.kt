package com.hayashi2026.leetcode.binarysearch

class `4Sum` {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            val solutions = threeSum(nums, target - nums[i], i + 1)
            for (solution in solutions) {
                solution.add(nums[i])
                result.add(solution)
            }
        }
        return result
    }

    fun threeSum(nums: IntArray, target: Int, start: Int): MutableList<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        for (i in start until nums.size - 2) {
            if (i > start && nums[i] == nums[i - 1]) continue
            val solutions = twoSum(nums, target - nums[i], i + 1, nums.size - 1)
            for (solution in solutions) {
                solution.add(nums[i])
                result.add(solution)
            }
        }
        return result
    }

    fun twoSum(nums: IntArray, target: Int, from: Int, to: Int): MutableList<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        var start = from
        var end = to
        while (start < end) {
            if (start > from && nums[start] == nums[start - 1]) {
                start++
                continue
            }
            if (end < to && nums[end] == nums[end + 1]) {
                end--
                continue
            }
            val sum = nums[start] + nums[end]
            if (sum > target) {
                end--
            } else if (sum < target) {
                start++
            } else {
                result.add(mutableListOf(nums[start], nums[end]))
                start++
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1, 0, -1, 0, -2, 2)
    val test = `4Sum`()
    println(test.fourSum(data, 0))
}