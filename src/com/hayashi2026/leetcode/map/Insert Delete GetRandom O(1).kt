package com.hayashi2026.leetcode.map

import java.util.*

class `Insert Delete GetRandom O(1)` {

    /** Initialize your data structure here. */
    val map = hashMapOf<Int, Int>()

    val array = arrayListOf<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map[`val`] != null) {
            return false
        }
        array.add(`val`)
        map[`val`] = array.lastIndex
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        map[`val`]?.let {
            val lastItem = array[array.lastIndex]
            array[it] = lastItem
            map[lastItem] = it
            map.remove(`val`)
            array.removeAt(array.lastIndex)
            return true
        }
        return false
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        if (array.size == 0) {
            return -1
        }
        val random = Random()
        val target = random.nextInt(array.size)
        return array[target]
    }
}