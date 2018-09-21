package com.hayashi2026.leetcode.topological

import java.util.*

class `Course Schedule` {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) {
            return true
        }
        val graph = MutableList<MutableSet<Int>>(numCourses, { mutableSetOf() })
        val map = hashSetOf<Int>()
        for (edge in prerequisites) {
            graph[edge[1]].add(edge[0])
        }
        val queue = LinkedList<Int>()
        for (i in 0 until graph.size) {
            if (graph[i].isEmpty()) {
                map.add(i)
                queue.offer(i)
            }
        }
        while (!queue.isEmpty()) {
            val head = queue.poll()
            for (i in 0 until graph.size) {
                graph[i].remove(head)
                if (!map.contains(i) && graph[i].isEmpty()) {
                    queue.offer(i)
                    map.add(i)
                }
            }
        }
        return map.size == numCourses
    }
}

fun main(args: Array<String>) {
    val data = arrayOf(intArrayOf(1, 0))
    val test = `Course Schedule`()
    test.canFinish(3, data)
}