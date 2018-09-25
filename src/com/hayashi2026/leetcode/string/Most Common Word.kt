package com.hayashi2026.leetcode.string

class `Most Common Word` {

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val array = paragraph.split(" ")
        val wordMap = hashMapOf<String, String>()
        val map = hashMapOf<String, Int>()
        for (str in array) {
            val word = str.toLowerCase().replace(Regex("[!?',;.]"), "")
            wordMap[word] = str
            if (map[word] == null) {
                map[word] = 0
            }
            map[word] = map[word]!! + 1
        }
        var res = ""
        var max = 0
        for (i in map) {
            if (i.value > max && !banned.contains(i.key.toLowerCase())) {
                max = i.value
                res = i.key
            }
        }
        return wordMap[res]!!.toLowerCase().replace(Regex("([!?',;.])$"), "")
    }
}


fun main(args: Array<String>) {
    val test = `Most Common Word`()
    test.mostCommonWord("a, a, a, a, b,b,b,c, c", arrayOf("a"))
}