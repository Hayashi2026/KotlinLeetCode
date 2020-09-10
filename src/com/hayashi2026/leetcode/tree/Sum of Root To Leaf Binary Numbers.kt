package tree

class `Sum of Root To Leaf Binary Numbers` {

    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0
        val res = mutableListOf<Int>()
        dfs(root, root!!.`val`, res)
        return res.sum()
    }

    fun dfs(root: TreeNode, num: Int, res: MutableList<Int>) {
        if (root.left == null && root.right == null) {
            res.add(num * 2 + root.`val`)
            return
        }
        root.left?.let {
            dfs(it, num * 2 + it.`val`, res)
        }
        root.right?.let {
            dfs(it, num * 2 + it.`val`, res)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
