import java.util.Stack

class `Flatten Binary Tree to Linked List` {

    fun flatten(root: TreeNode?): Unit {
        val stack = Stack<TreeNode>()
        root?.let { stack.push(it) }
        val dummy = TreeNode(-1)
        var preNode = dummy
        while (!stack.isEmpty()) {
            val node = stack.pop()
            node.right?.let { stack.push(it) }
            node.left?.let { stack.push(it) }
            preNode.left = null
            preNode.right = node
            preNode = node
        }
    }
}