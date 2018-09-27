package com.hayashi2026.leetcode.array

class `Count Primes` {

    fun countPrimes(n: Int): Int {
        val array = BooleanArray(n, { true })
        for (i in 2 until n) {
            loop@ for (j in 2 until n) {
                if (i * j > array.size - 1) break@loop
                array[i * j] = false
            }
        }
        var count = 0
        for (i in 2 until array.size) {
            if (array[i]) count++
        }
        return count
    }
}

fun main(args: Array<String>) {
    val test = `Count Primes`()
    println(test.countPrimes(10))
}