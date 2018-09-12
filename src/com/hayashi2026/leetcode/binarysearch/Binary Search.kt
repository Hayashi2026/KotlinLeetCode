package com.hayashi2026.leetcode.binarysearch

class `Binary Search` {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var start = 0
        var end = nums.size - 1
        while (start + 1 < end) {
            val mid = start + (end - start) / 2
            when {
                nums[mid] > target -> end = mid - 1
                nums[mid] < target -> start = mid + 1
                else -> return mid
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

//    fun binarySearch(nums: IntArray, target: Int, start: Int, end: Int): Int {
//        if (start == end) {
//            return if (nums[start] == target) start else -1
//        }
//        val center = start + (end - start) / 2
//        if (nums[center] > target) {
//            return binarySearch(nums, target, start, center)
//        } else if (nums[center] < target){
//            return binarySearch(nums, target, center + 1, end)
//        } else {
//            return center
//        }
//    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(-1,0,3,5,9,12)
    val test = `Binary Search`()
    println(test.search(data, 2))
}