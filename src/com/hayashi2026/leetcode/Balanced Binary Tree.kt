import kotlin.math.abs
import kotlin.math.max

class `Balanced Binary Tree` {

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false
        }
        return isBalanced(root.left) && isBalanced(root.right)
    }

    fun getDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return max(getDepth(root.left), getDepth(root.right)) + 1
    }
}