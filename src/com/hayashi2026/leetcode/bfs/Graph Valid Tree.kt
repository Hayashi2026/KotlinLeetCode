package bfs

import java.util.*

class `Graph Valid Tree` {

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (n == 0 || edges.size != n - 1) {
            return false
        }
        val queue = LinkedList<Int>()
        val graph = buildGraph(n, edges)
        val set = hashSetOf<Int>()
        queue.offer(0)
        set.add(0)
        while (!queue.isEmpty()) {
            val node = queue.poll()
            graph[node]?.forEach {
                if (!set.contains(it)) {
                    set.add(it)
                    queue.offer(it)
                }
            }

        }
        return set.size == n
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            graph[i] = mutableListOf()
        }
        edges.forEach {
            graph[it[0]]?.add(it[1])
            graph[it[1]]?.add(it[0])
        }
        return graph
    }
}

fun main(args: Array<String>) {
    val data = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(1, 4))
    val test = `Graph Valid Tree`()
    println(test.validTree(5, data))
}