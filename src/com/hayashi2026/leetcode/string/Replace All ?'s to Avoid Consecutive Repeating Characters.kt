package string

fun main() {
    val test = `Replace All ?'s to Avoid Consecutive Repeating Characters`()
    println(test.modifyString("??????"))
}

class `Replace All ?'s to Avoid Consecutive Repeating Characters` {

    fun modifyString(s: String): String {
        val nums = mutableListOf<Int>()
        for (i in 0 until s.length) {
            if (s[i] == '?') {
                nums.add(i)
            }
        }
        val ans = mutableListOf<String>()
        modifyString(StringBuilder(s), nums, 0, ans)
        return ans[0]
    }

    fun modifyString(s: StringBuilder, nums: MutableList<Int>, start: Int, ans: MutableList<String>) {
        if (ans.size > 0) {
            return
        }
        if (start >= nums.size) {
            if (checkValid(s)) {
                ans.add(s.toString())
            }
            return
        }
        if (ans.size == 0) {
            for (i in 'a'.toInt()..'z'.toInt()) {
                s[nums[start]] = i.toChar()
                modifyString(s, nums, start + 1, ans)
            }
        }

    }


    fun checkValid(s: StringBuilder): Boolean {
        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                return false
            }
        }
        return true
    }
}