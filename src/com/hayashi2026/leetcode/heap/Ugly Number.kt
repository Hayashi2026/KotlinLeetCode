package com.hayashi2026.leetcode.heap

class `Ugly Number` {
    fun isUgly(num: Int): Boolean {
        var number = num
        while (number >= 2) {
            if (number % 2 == 0) number /= 2
            else if (number % 3 == 0) number /= 3
            else if (number % 5 == 0) number /= 5
            else return false
        }
        return number == 1
    }
}

fun main(args: Array<String>) {
    val test = `Ugly Number`()
    println(test.isUgly(21))
}