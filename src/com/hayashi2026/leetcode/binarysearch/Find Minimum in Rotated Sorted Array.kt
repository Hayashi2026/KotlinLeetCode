package com.hayashi2026.leetcode.binarysearch

class `Find Minimum in Rotated Sorted Array` {

//    [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] < nums[nums.size - 1]) {
                end = mid
            } else {
                start = mid
            }
        }
        return if (nums[start] < nums[end]) nums[start] else nums[end]
    }

//    fun findMin(nums: IntArray): Int {
//        var start = 0
//        var end = nums.size - 1
//        while (start + 1 < end) {
//            val mid = start + (end - start) / 2
//            if (nums[mid] > nums[0] && nums[mid] > nums[nums.size - 1]) {
//                start = mid
//            } else if (nums[mid] < nums[0] && nums[mid] < nums[nums.size - 1]){
//                end = mid
//            } else {
//                return nums[0]
//            }
//        }
//        return if (nums[start] < nums[end]) nums[start] else nums[end]
//    }
}

