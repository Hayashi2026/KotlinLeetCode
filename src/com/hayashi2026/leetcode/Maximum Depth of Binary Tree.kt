import java.util.LinkedList

class `Maximum Depth of Binary Tree` {

    fun maxDepth(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.add(it) }
        var depth = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            depth++
            for (i in 0 until size) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }
        return depth
    }
}