class MinimumWindowSubstring {

    fun minWindow(s: String, t: String): String {
        val sourceCharArray = s.toCharArray()
        val targetCharArray = t.toCharArray()
        var left = 0
        var min = Integer.MAX_VALUE
        var result = ""
        val sourceMap = IntArray(256)
        val targetMap = IntArray(256)
        targetCharArray.forEach {
            targetMap[it.toInt()]++
        }
        for (i in 0 until sourceCharArray.size) {
            val item = sourceCharArray[i]
            sourceMap[item.toInt()]++
            while (isValid(sourceMap, targetMap)) {
                if (i - left < min) {
                    min = i - left
                    result = s.substring(left, i + 1)
                }
                val leftCharItem = sourceCharArray[left]
                sourceMap[leftCharItem.toInt()]--
                left++
            }
        }
        return result
    }

    private fun isValid(source: IntArray, target: IntArray): Boolean {
        for (i in 0..255) {
            if (source[i] < target[i]) {
                return false
            }
        }
        return true
    }

}

fun main(args: Array<String>) {
    val test = MinimumWindowSubstring()
    println(test.minWindow("bba", "ab"))
}