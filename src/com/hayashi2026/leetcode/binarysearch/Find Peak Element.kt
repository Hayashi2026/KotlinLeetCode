package com.hayashi2026.leetcode.binarysearch

class `Find Peak Element` {

//    nums = [1,2,1,3,5,6,4]

    fun findPeakElement(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] < nums[mid + 1]) {
                start = mid
            } else {
                end = mid
            }
        }
        return if (nums[start] > nums[end]) start else end
    }
}