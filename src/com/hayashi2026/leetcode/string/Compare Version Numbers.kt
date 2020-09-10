package string

fun main() {
    val test = `Compare Version Numbers`()
    test.compareVersion("1.0.1", "1")
}

class `Compare Version Numbers` {

    fun compareVersion(version1: String, version2: String): Int {
        val arr1 = version1.split(".")
        val arr2 = version2.split(".")
        val len1 = arr1.size
        val len2 = arr2.size
        val maxLen = Math.max(len1, len2)
        for (i in 0 until maxLen) {
            val a = if (i >= len1) 0 else arr1[i].toInt()
            val b = if (i >= len2) 0 else arr2[i].toInt()
            if (a != b) {
                return if (a > b) 1 else -1
            }
        }
        return 0
    }
}