import java.util.LinkedList

class `01Matrix` {

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val queue = LinkedList<Pair<Int, Int>>()
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                if (matrix[i][j] == 0) {
                    queue.offer(Pair(i, j))
                } else {
                    matrix[i][j] = Int.MAX_VALUE
                }
            }
        }
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
        while (!queue.isEmpty()) {
            val pair = queue.poll()
            val x = pair.first
            val y = pair.second
            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]
                if (nextX < 0 || nextX >= matrix.size || nextY < 0 || nextY >= matrix[0].size || matrix[x][y] >= matrix[nextX][nextY]) {
                    continue
                }
                matrix[nextX][nextY] = matrix[x][y] + 1
                queue.offer(Pair(nextX, nextY))
            }
        }
        return matrix
    }

}