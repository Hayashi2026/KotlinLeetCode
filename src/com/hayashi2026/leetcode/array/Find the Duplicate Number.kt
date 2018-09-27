package com.hayashi2026.leetcode.array

class `Find the Duplicate Number` {

//    fun findDuplicate(nums: IntArray): Int {
//        for (i in 0 until nums.size) {
//            for (j in i + 1 until nums.size) {
//                if (nums[j] == nums[i]) {
//                    return nums[j]
//                }
//            }
//        }
//        return -1
//    }

    fun findDuplicate(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            var count = 0
            for (i in nums) {
                if (i <= mid) {
                    count++
                }
            }
            if (count > mid) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start
    }

}