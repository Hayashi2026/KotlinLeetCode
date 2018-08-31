class FindAllAnagramsInAString {

    fun findAnagrams(s: String, p: String): List<Int> {
        val sourceArray = s.toCharArray()
        val targetArray = p.toCharArray()
        val targetMap = IntArray(256)
        targetArray.forEach {
            targetMap[it.toInt()]++
        }
        var leftIndex = 0
        var count = p.length
        val result = arrayListOf<Int>()
        for (rightIndex in 0 until s.length) {
            if (targetMap[sourceArray[rightIndex].toInt()]-- >= 1) count--
            if (count == 0) result.add(leftIndex)
            if (rightIndex - leftIndex == p.length) {
                if (targetMap[sourceArray[leftIndex].toInt()]++ >= 0) count++
                leftIndex++
            }
        }
        return result
    }

}

fun main(args: Array<String>) {
    val test = FindAllAnagramsInAString()
    println(test.findAnagrams("cbaebabacd", "abc"))
}