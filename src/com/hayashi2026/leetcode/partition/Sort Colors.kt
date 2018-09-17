package com.hayashi2026.leetcode.partition

class `Sort Colors` {

    fun sortColors(nums: IntArray): Unit {
        var start = 0
        var end = nums.size - 1
        var i = 0
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start, i)
                start++
                i++
            } else if (nums[i] == 1) {
                i++
            } else {
                swap(nums, end, i)
                end--
            }
        }
    }

    fun swap(nums: IntArray, left: Int, right: Int) {
        val tmp = nums[right]
        nums[right] = nums[left]
        nums[left] = tmp
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(2,0,2,1,1,0)
    val test = `Sort Colors`()
    test.sortColors(data)
}
