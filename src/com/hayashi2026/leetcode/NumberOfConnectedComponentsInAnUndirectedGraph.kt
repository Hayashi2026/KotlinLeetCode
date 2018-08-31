import java.util.Stack

class NumberOfConnectedComponentsInAnUndirectedGraph {

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var result = 0
        val visited = Array(n, { false })
        val adjList = Array(n, {
            mutableListOf<Int>()
        })
        val stack = Stack<Int>()
        edges.forEach {
            adjList[it[0]].add(it[1])
            adjList[it[1]].add(it[0])
        }
        for (i in 0 until n) {
            if (!visited[i]) {
                result++
                visited[i] = true
                stack.push(i)
                while (!stack.isEmpty()) {
                    val node = stack.pop()
                    visited[node] = true
                    for (item in adjList[node]) {
                        if (!visited[item]) {
                            stack.push(item)
                        }
                    }
                }
            }
        }
        return result
    }
}