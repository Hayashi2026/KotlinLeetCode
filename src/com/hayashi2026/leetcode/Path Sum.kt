class `Path Sum` {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return traverse(root, sum)
    }

    fun traverse(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null) {
            return sum == root.`val`
        }
        return traverse(root.left, sum - root.`val`) || traverse(root.right, sum - root.`val`)
    }
}