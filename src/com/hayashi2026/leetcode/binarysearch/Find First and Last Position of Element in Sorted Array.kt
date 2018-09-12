package com.hayashi2026.leetcode.binarysearch

class `Find First and Last Position of Element in Sorted Array` {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        val firstIndex = searchFirstElement(nums, target)
        val lastIndex = searchLastElement(nums, target)
        return intArrayOf(firstIndex, lastIndex)
    }

    private fun searchFirstElement(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] > target) {
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid
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

    private fun searchLastElement(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] > target) {
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                start = mid
            }
        }
        if (nums[end] == target) {
            return end
        }
        if (nums[start] == target) {
            return start
        }
        return -1
    }
}