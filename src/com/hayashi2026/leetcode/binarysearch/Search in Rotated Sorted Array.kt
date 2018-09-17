package com.hayashi2026.leetcode.binarysearch

class `Search in Rotated Sorted Array` {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] < nums[nums.size - 1]) {
                if (target > nums[mid] && target <= nums[nums.size - 1]) {
                    start = mid
                } else {
                    end = mid
                }
            } else {
                if (target < nums[mid] && target >= nums[0]) {
                    end = mid
                } else {
                    start = mid
                }
            }
        }
        if (nums[start] == target) {
            return start
        }
        if (nums[end] == target) {
            return end
        }
        return -1
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1, 3, 5)
    val test = `Search in Rotated Sorted Array`()
    test.search(data, 1)
}