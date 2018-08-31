import java.util.LinkedList

class MinimumDepthOfBinaryTree {

    fun minDepth(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.add(it) }
        var minDepth = 0
        loop@ while (!queue.isEmpty()) {
            val size = queue.size
            minDepth++
            for (i in 0 until size) {
                val node = queue.poll()
                if (node.left == null || node.right == null) {
                    break@loop
                }
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }
        return minDepth
    }


}