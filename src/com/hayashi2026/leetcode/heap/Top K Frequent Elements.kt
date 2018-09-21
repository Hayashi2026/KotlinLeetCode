package com.hayashi2026.leetcode.heap

import java.util.*

class `Top K Frequent Elements` {

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            if (map[nums[i]] != null) {
                val v = map[nums[i]]!!
                map[nums[i]] = v + 1
            } else {
                map[nums[i]] = 1
            }
        }
        val heap = PriorityQueue<Node>(kotlin.Comparator { o1, o2 ->  o2.count - o1.count})
        for (i in map) {
            heap.add(Node(i.value, i.key))
        }
        val result = arrayListOf<Int>()
        for (i in 0 until k) {
            val head = heap.poll()
            result.add(head.num)
        }
        return result
    }

    class Node(val count: Int, val num: Int)
}