import java.util.*
import kotlin.Comparator

fun main() {
    val test = `The Skyline Problem`()
    test.getSkyline(arrayOf(intArrayOf(2,9,10), intArrayOf(3,7,15), intArrayOf(5,12,12), intArrayOf(15,20,10), intArrayOf(19,24,8)))
}

class `The Skyline Problem` {

    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val points = mutableListOf<IntArray>()
        for (building in buildings) {
            points.add(intArrayOf(building[0], building[2], 0))
            points.add(intArrayOf(building[1], building[2], 1))
        }
        points.sortWith(Comparator{ a, b ->
            a[0] - b[0]
        })
        val queue = PriorityQueue<Int>(10, Comparator { a, b ->
            b - a
        })
        queue.offer(0)
        val res = mutableListOf<List<Int>>()
        var preHeight = 0
        for (i in 0 until points.size) {
            if (points[i][2] == 0) {
                queue.add(points[i][1])
            } else {
                queue.remove(points[i][1])
            }
            val height = queue.peek()
            if (height != preHeight) {
                res.add(listOf(points[i][0], height))
                preHeight = height
            }
        }
        return res
    }
}