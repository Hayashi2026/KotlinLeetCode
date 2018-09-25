package com.hayashi2026.leetcode

import java.lang.Math.abs
import java.util.*

class `Reverse Integer` {

    fun reverse(x: Int): Int {
        val array = LinkedList<Long>()
        var i = 0
        var num = abs(x.toLong())
        while (num != 0L) {
            val digit = num % 10
            array.add(digit)
            num /= 10
            i++
        }
        var res = 0L
        while (!array.isEmpty()) {
            val head = array.poll()
            res = res * 10 + head
            if (res > Int.MAX_VALUE || res * -1 < Int.MIN_VALUE) {
                return 0
            }
        }
        return if (x > 0) res.toInt() else -res.toInt()
    }

    fun reverse2(x: Int): Int {
        var num = x
        var res = 0
        while (num != 0) {
            val pop = num % 10
            num /= 10
            if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && pop > 7)) {
                return 0
            }
            if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && pop < -8)) {
                return 0
            }
            res = res * 10 + pop
        }
        return res
    }
}

fun main(args: Array<String>) {
    val test = `Reverse Integer`()
    println(test.reverse2(-2345678))
}