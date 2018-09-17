package com.hayashi2026.leetcode.binarysearch

import java.lang.Math.abs

class `Pow(x, n)` {

    fun myPow(x: Double, n: Int): Double {
        val num = if (n > 0) x else 1 / x
        return pow(num, n)
    }

    fun pow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        val half = pow(x, n / 2)
        if (n % 2 == 0) {
            return half * half
        } else {
            return half * half * x
        }
    }
}

fun main(args: Array<String>) {
    val test = `Pow(x, n)`()
    test.myPow(1.00000, -2147483648)
}