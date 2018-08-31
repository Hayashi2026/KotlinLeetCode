import java.util.*

class `Binary Tree Inorder Traversal` {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traversal(root, result)
        return result
    }

    fun traversal(root: TreeNode?, result: MutableList<Int>) {
        if (root == null) {
            return
        }
        traversal(root.left, result)
        result.add(root.`val`)
        traversal(root.right, result)
    }

//    fun inorderTraversal(root: TreeNode?): List<Int> {
//        val result = mutableListOf<Int>()
//        val stack = Stack<TreeNode>()
//        if (root == null) {
//            return result
//        }
//        var node = root
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node)
//                node = node.left
//            }
//            node = stack.pop()
//            result.add(node.`val`)
//            node = node.right
//        }
//        return result
//    }
}