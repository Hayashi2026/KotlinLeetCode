package com.hayashi2026.leetcode.array

class `Contains Duplicate II` {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            if (map[nums[i]] != null && i - map[nums[i]]!! <= k) {
                return true
            }
            map[nums[i]] = i
        }
        return false
    }

//    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
//         var start = 0
//         var end = if (k > nums.size - 1) nums.size - 1 else k
//         while (end < nums.size) {
//             if (containsDuplicate(nums.sliceArray(start..end))) {
//                 return true
//             }
//             start++
//             end++
//         }
//         return false
//     }
//
//     fun containsDuplicate(nums: IntArray): Boolean {
//         nums.sort()
//         for (i in 1 until nums.size) {
//             if (nums[i] == nums[i - 1]) {
//                 return true
//             }
//         }
//         return false
//     }


}

fun main(args: Array<String>) {
    val test = `Contains Duplicate II`()
    test.containsNearbyDuplicate(intArrayOf(99, 99), 2)
}