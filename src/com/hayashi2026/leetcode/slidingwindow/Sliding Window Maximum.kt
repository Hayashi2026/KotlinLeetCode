package com.hayashi2026.leetcode.slidingwindow

import java.util.*

class `Sliding Window Maximum` {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        val res = IntArray(nums.size - k + 1)
        val deque = ArrayDeque<Int>()
        for (i in 0 until nums.size) {
            while (deque.isNotEmpty() && nums[deque.last] < nums[i]) {
                deque.pollLast()
            }
            deque.offer(i)
            if (deque.peek() == i - k) {
                deque.pollFirst()
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()]
            }
        }
        return res
    }

//    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
//        val res = IntArray(nums.size - k + 1)
//        if (nums.isEmpty()) return intArrayOf()
//        var start = 0
//        var end = k - 1
//        while (end < nums.size) {
//            var max = Int.MIN_VALUE
//            for (i in start..end) {
//                if (nums[i] > max) {
//                    max = nums[i]
//                }
//            }
//            res[start] = max
//            start++
//            end++
//        }
//        return res
//    }
}