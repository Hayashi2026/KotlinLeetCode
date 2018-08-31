import java.util.Stack

class BinaryTreePreorderTraversal {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result
        val stack = Stack<TreeNode>()
        stack.add(root)
        while (!stack.isEmpty()) {
            val node = stack.pop()
            node.right?.let {
                stack.push(node.right)
            }
            node.left?.let {
                stack.push(node.left)
            }
            result.add(node.`val`)
        }
        return result
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}