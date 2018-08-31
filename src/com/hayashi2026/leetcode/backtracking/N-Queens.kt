package backtracking

class `N-Queens` {

    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val book = BooleanArray(n, { false })
        dfs(n, mutableListOf(), result, book)
        return result
    }

    fun dfs(n: Int, solution: MutableList<Int>, result: MutableList<List<String>>, book: BooleanArray) {
        if (solution.size == n) {
            result.add(buildResult(solution, n))
        }
        for (i in 0 until n) {
            if (!book[i]) {
                solution.add(i)
                book[i] = true
                if (isValid(solution)) {
                    dfs(n, solution, result, book)
                }
                solution.removeAt(solution.lastIndex)
                book[i] = false
            }
        }
    }

    fun buildResult(solution: MutableList<Int>, n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in solution) {
            result.add(buildRow(i, n))
        }
        return result
    }

    fun buildRow(num: Int, n: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until n) {
            if (i == num) {
                stringBuilder.append("Q")
            } else {
                stringBuilder.append(".")
            }
        }
        return stringBuilder.toString()
    }

    fun isValid(solution: MutableList<Int>): Boolean {
        val row = solution.lastIndex
        val col = solution[row]
        for (i in 0 until solution.size - 1) {
            val rowOfItem = i
            val colOfItem = solution[i]
            if (row - rowOfItem == col - colOfItem) {
                return false
            }
            if (row - rowOfItem == colOfItem - col) {
                return false
            }
        }
        return true
    }
}

//[["Q...",
//  ".Q..",
//  "..Q.",
//  "...Q"],
//
//["Q...", 0 0  1 1 2 2 3 3
// ".Q..",
// "...Q",  3 0  2 1    1 2   0 3
// "..Q."], 0 2  1 3
//
//["Q...",
// "..Q.",
// ".Q..",
// "...Q"],
//
//["Q...",
// "..Q.",
// "...Q",
// ".Q.."],["Q...","...Q",".Q..","..Q."],["Q...","...Q","..Q.",".Q.."],[".Q..","Q...","..Q.","...Q"],[".Q..","Q...","...Q","..Q."],[".Q..","..Q.","Q...","...Q"],[".Q..","..Q.","...Q","Q..."],[".Q..","...Q","Q...","..Q."],[".Q..","...Q","..Q.","Q..."],["..Q.","Q...",".Q..","...Q"],["..Q.","Q...","...Q",".Q.."],["..Q.",".Q..","Q...","...Q"],["..Q.",".Q..","...Q","Q..."],["..Q.","...Q","Q...",".Q.."],["..Q.","...Q",".Q..","Q..."],["...Q","Q...",".Q..","..Q."],["...Q","Q...","..Q.",".Q.."],["...Q",".Q..","Q...","..Q."],["...Q",".Q..","..Q.","Q..."],["...Q","..Q.","Q...",".Q.."],["...Q","..Q.",".Q..","Q..."]]
//
//[[".Q..",
//  "...Q",
//  "Q...",
//  "..Q."],
//
//["..Q.",
// "Q...",
// "...Q",
// ".Q.."]]
//
//         1 2  3  4
//         5 6  7  8
//         9 10 11 12