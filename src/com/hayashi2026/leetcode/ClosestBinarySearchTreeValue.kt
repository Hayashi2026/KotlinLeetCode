import java.util.LinkedList

class ClosestBinarySearchTreeValue {

    fun closestValue(root: TreeNode?, target: Double): Int {
        val queue = LinkedList<TreeNode>()
        root?.let {
            queue.add(it)
        }
        var min = Double.MAX_VALUE
        var result = -1
        while (!queue.isEmpty()) {
            val node = queue.poll()
            val diff = Math.abs(node.`val`.toDouble() - target)
            if (diff < min) {
                min = diff
                result = node.`val`
            }
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        return result
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}