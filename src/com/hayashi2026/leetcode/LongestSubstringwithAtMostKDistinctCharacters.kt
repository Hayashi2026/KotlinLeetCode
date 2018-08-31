class LongestSubstringwithAtMostKDistinctCharacters {

    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val map = IntArray(256)
        var leftIndex = 0
        var max = 0
        val charArray = s.toCharArray()
        for (rightIndex in 0 until charArray.size) {
            map[charArray[rightIndex].toInt()]++
            while (getMapSize(map) > k) {
                map[charArray[leftIndex].toInt()]--
                leftIndex++
            }
            if (rightIndex - leftIndex + 1 > max) {
                max = rightIndex - leftIndex + 1
            }
        }
        return max
    }

    private fun getMapSize(array: IntArray): Int {
        var sum = 0
        array.forEach {
            if (it > 0) {
                sum++
            }
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val test = LongestSubstringwithAtMostKDistinctCharacters()
    println(test.lengthOfLongestSubstringKDistinct("aba", 1))
}
