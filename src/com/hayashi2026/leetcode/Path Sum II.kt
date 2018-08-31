import java.util.Stack

class `Path Sum II` {

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val solution = mutableListOf<Int>()
        traverse(root, sum, result, solution)
        return result
    }

    fun traverse(node: TreeNode?, sum: Int, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        if (node == null) {
            return
        }
        val remainder = sum - node.`val`
        if (node.left == null && node.right == null) {
            if (remainder == 0) {
                solution.add(node.`val`)
                val list = mutableListOf<Int>()
                list.addAll(solution)
                result.add(list)
                solution.removeAt(solution.lastIndex)
            }
            return
        }
        solution.add(node.`val`)
        traverse(node.left, remainder, result, solution)
        traverse(node.right, remainder, result, solution)
        solution.removeAt(solution.lastIndex)
    }
}


