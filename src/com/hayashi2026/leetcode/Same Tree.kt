class `Same Tree` {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return isSameRoot(p, q)
    }

    private fun isSameRoot(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` == q?.`val`) {
            return isSameRoot(p?.left, q?.left) && isSameRoot(p?.right, q?.right)
        }
        return false
    }




}

data class concatString(val string1: String, val string2: String) {


}

fun main(args: Array<String>) {
    println(concatString("ice", "1000"))

}