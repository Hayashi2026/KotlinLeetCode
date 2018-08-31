package com.hayashi2026.leetcode


fun main(args: Array<String>) {
    val testArray = intArrayOf(3, 2, 4)
    val solution = Solution()
    val result = solution.twoSum(testArray, 6)
    println(result[0])
    println(result[1])
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map[nums[i]] != null) {
                map[nums[i]] = i
            }
        }
        for (i in nums.indices) {
            val difference = target - nums[i]
            if (map.containsKey(difference)) {
                return intArrayOf(i, map[target - nums[i]]!!)
            }
        }
        return intArrayOf()
    }
}