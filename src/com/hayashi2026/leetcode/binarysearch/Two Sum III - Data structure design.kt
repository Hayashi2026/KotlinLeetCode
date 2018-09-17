package com.hayashi2026.leetcode.binarysearch

class `Two Sum III - Data structure design` {

    /** Initialize your data structure here. */

    val map = mutableMapOf<Int, Int>()


    /** Add the number to an internal data structure.. */
    fun add(number: Int) {
        val value = map[number]
        if (value != null) {
            map[number] = value + 1
        } else {
            map[number] = 1
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    fun find(value: Int): Boolean {
        map.forEach {
            val number = value - it.key
            val numberCount = map[number]
            numberCount?.let {_ ->
                if (number == it.key && numberCount > 1) {
                    return true
                }
                if (number != it.key && it.value > 0 && numberCount > 0) {
                    return true
                }
            }

        }
        return false
    }
}

fun main(args: Array<String>) {
    val test = `Two Sum III - Data structure design`()
    test.add(1)
    test.add(3)
    test.add(5)
    println(test.find(4))
//    println(test.find(7))
}