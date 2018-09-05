package com.hayashi2026.leetcode.twopointers

class `Move Zeroes` {

    fun moveZeroes(nums: IntArray): Unit {
        var pointer = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                swap(i, pointer, nums)
                pointer++
            }
        }
    }

    fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(0, 0, 1)
    val test = `Move Zeroes`()
    test.moveZeroes(data)
    println(data)
}