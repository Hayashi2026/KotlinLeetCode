import java.util.Stack

class FriendCircles {

    fun findCircleNum(M: Array<IntArray>): Int {
        val visited = Array(M.size, { false })
        val stack = Stack<Int>()
        var circleNum = 0
        for (i in 0 until M.size) {
            if (!visited[i]) {
                stack.push(i)
                circleNum++
                while (!stack.isEmpty()) {
                    val node = stack.pop()
                    visited[node] = true
                    for (j in 0 until M[node].size) {
                        if (!visited[j] && M[node][j] == 1) {
                            stack.push(j)
                        }
                    }
                }
            }
        }
        return circleNum
    }


}