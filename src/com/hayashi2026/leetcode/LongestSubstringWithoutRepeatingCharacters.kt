class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        val charArr = s.toCharArray()
        var max = 0
        var start = 0
        val set = hashSetOf<Char>()
        for (i in 0 until charArr.size) {
            if (!set.contains(charArr[i])) {
                set.add(charArr[i])
                if (max < set.size) {
                    max = set.size
                }
            } else {
                while (set.contains(charArr[i])) {
                    set.remove(charArr[start])
                    start++
                }
                set.add(charArr[i])
            }
        }
        return max
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        val charArr = s.toCharArray()
        val map = IntArray(256)
        var answer = 0
        var left = 0
        for (right in 0 until charArr.size) {
            val item = charArr[right].toInt()
            map[item]++
            while (map[item] > 1) {
                map[charArr[left].toInt()]--
                left++
            }
            answer = Math.max(answer, right - left + 1)
        }
        return answer
    }

}

fun main(args: Array<String>) {
    val test = LongestSubstringWithoutRepeatingCharacters()
    println(test.lengthOfLongestSubstring2("aab"))
}