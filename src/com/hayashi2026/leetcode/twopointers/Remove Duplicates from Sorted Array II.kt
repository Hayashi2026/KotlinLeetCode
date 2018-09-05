package com.hayashi2026.leetcode.twopointers

class `Remove Duplicates from Sorted Array II` {

    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 0
        var second = false
        for (i in 1 until nums.size) {
            if (nums[i] != nums[pointer]) {
                second = false
                nums[++pointer] = nums[i]
            } else {
                if (!second) {
                    nums[++pointer] = nums[i]
                    second = true
                }
            }
        }
        return pointer + 1
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(0,0,1,1,1,1,2,3,3)
    val test = `Remove Duplicates from Sorted Array II`()
    println(test.removeDuplicates(data))
}