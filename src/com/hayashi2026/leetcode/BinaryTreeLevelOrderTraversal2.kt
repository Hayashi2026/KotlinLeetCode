import java.util.LinkedList

class BinaryTreeLevelOrderTraversal2 {

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        val result = mutableListOf<List<Int>>()
        root?.let { queue.add(root) }
        while (!queue.isEmpty()) {
            val size = queue.size
            val levelList = mutableListOf<Int>()
            for (i in 0 until size) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
                levelList.add(node.`val`)
            }
            result.add(0, levelList)
        }
        return result
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}