package com.hayashi2026.leetcode.binarysearch

import kotlin.math.abs

class `3Sum Closest` {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closestSum = Int.MAX_VALUE
        var result = 0
        for (i in 0 until nums.size - 2) {
            var start = i + 1
            var end = nums.size - 1
            while (start < end) {
                val sum = nums[i] + nums[start] + nums[end]
                if (abs(sum - target) < closestSum) {
                    closestSum = abs(sum - target)
                    result = sum
                }
                if (sum > target) {
                    end--
                } else if (sum < target) {
                    start++
                } else {
                    return sum
                }
            }
        }
        return result
    }

//    fun threeSumClosest(nums: IntArray, target: Int): Int {
//        var closestSum = Int.MAX_VALUE
//        var result = 0
//        for (i in 0 until nums.size - 2) {
//            for (j in i + 1 until nums.size - 1) {
//                for (k in j + 1 until nums.size) {
//                    val sum = nums[i] + nums[j] + nums[k]
//                    if (abs(sum - target) < closestSum) {
//                        closestSum = abs(sum -target)
//                        result = sum
//                    }
//                }
//            }
//        }
//        return result
//    }

}

fun main(args: Array<String>) {
    val data = intArrayOf(-3, -2, -5, 3, -4)
    val test = `3Sum Closest`()
    println(test.threeSumClosest(data, -1))
}