class LongestSubstringWithAtMostTwoDistinctCharacters {

    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val charArray = s.toCharArray()
        val map = IntArray(256)
        var leftIndex = 0
        var max = 0
        var count = 0
        for (rightIndex in 0 until charArray.size) {
            if (map[charArray[rightIndex].toInt()]++ == 0) {
                count++
            }
            while (count > 2) {
                if (--map[charArray[leftIndex].toInt()] == 0) {
                    count--
                }
                leftIndex++
            }
            if (rightIndex - leftIndex + 1 > max) {
                max = rightIndex - leftIndex + 1
            }
        }
        return max
    }
}

fun main(args: Array<String>) {
    val test = LongestSubstringWithAtMostTwoDistinctCharacters()
    println(test.lengthOfLongestSubstringTwoDistinct("abc"))
}