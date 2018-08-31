class `Binary Tree Paths` {

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        traversal(root, StringBuilder(), result)
        return result
    }

    fun traversal(root: TreeNode?, path: StringBuilder, result: MutableList<String>) {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null) {
            result.add("$path${root.`val`}")
            return
        }
        path.append("${root.`val`}->")
        traversal(root.left, path, result)
        traversal(root.right, path, result)
        path.delete(path.length - "${root.`val`}->".length, path.length)
    }
}