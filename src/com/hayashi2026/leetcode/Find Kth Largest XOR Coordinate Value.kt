import java.util.*
import kotlin.Comparator

fun main() {
    val test = `Find Kth Largest XOR Coordinate Value`()
    println(test.kthLargestValue(arrayOf(intArrayOf(5, 2), intArrayOf(1, 6)), 2))
}

class `Find Kth Largest XOR Coordinate Value` {

    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val res = Array(matrix.size) { IntArray(matrix[0].size) }
        val queue = PriorityQueue<Int>();
        res[0][0] = matrix[0][0]
        queue.offer(res[0][0])
        for (i in 1 until matrix.size) {
            res[i][0] = res[i - 1][0] xor matrix[i][0]
            queue.offer(res[i][0])
            if (queue.size > k) {
                queue.poll()
            }
        }
        for (i in 1 until matrix[0].size) {
            res[0][i] = res[0][i - 1] xor matrix[0][i]
            queue.offer(res[0][i])
            if (queue.size > k) {
                queue.poll()
            }
        }
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                res[i][j] = res[i - 1][j - 1] xor res[i][j - 1] xor res[i - 1][j] xor matrix[i][j]
                queue.offer(res[i][j])
                if (queue.size > k) {
                    queue.poll()
                }
            }
        }
        return queue.poll()
    }
}