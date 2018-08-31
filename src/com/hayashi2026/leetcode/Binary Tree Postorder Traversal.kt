class `Binary Tree Postorder Traversal` {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traversal(root, result)
        return result
    }

    fun traversal(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) {
            return
        }
        traversal(node.left, result)
        traversal(node.right, result)
        result.add(node.`val`)
    }
}