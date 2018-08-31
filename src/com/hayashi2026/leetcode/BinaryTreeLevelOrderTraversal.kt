import java.util.LinkedList

class BinaryTreeLevelOrderTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val level = mutableListOf<Int>()
            for (i in 0 until queue.size) {
                val current = queue.poll()
                current.left?.let {
                    queue.offer(it)
                }
                current.right?.let {
                    queue.offer(it)
                }
                level.add(current.`val`)
            }
            result.add(level)
        }
        return result
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

