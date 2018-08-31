import java.util.LinkedList

class SymmetricTree {


    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        val queueLeft = LinkedList<TreeNode>()
        val queueRight = LinkedList<TreeNode>()
        queueLeft.offer(root.left)
        queueRight.offer(root.right)
        while (!queueLeft.isEmpty()) {
            val leftNode = queueLeft.poll()
            val rightNode = queueRight.poll()
            if (leftNode == null && rightNode == null) continue
            if (leftNode == null || rightNode == null) return false
            if (leftNode.`val` != rightNode.`val`) {
                return false
            }
            queueLeft.offer(leftNode.left)
            queueLeft.offer(leftNode.right)
            queueRight.offer(rightNode.right)
            queueRight.offer(rightNode.left)
        }
        return true
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main(args: Array<String>) {
    val root = SymmetricTree.TreeNode(1)
    root.left =  SymmetricTree.TreeNode(2)
    root.right =  SymmetricTree.TreeNode(2)
    root.left?.left =  SymmetricTree.TreeNode(3)
    root.left?.right =  SymmetricTree.TreeNode(4)
    root.right?.left =  SymmetricTree.TreeNode(4)
    root.right?.right =  SymmetricTree.TreeNode(3)

    val test = SymmetricTree()
    println(test.isSymmetric(root))

}