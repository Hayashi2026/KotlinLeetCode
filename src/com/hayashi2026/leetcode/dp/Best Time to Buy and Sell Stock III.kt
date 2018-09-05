package com.hayashi2026.leetcode.dp

class `Best Time to Buy and Sell Stock III` {

    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        val left = IntArray(prices.size)
        left[0] = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            min = Math.min(prices[i], min)
            left[i] = Math.max(prices[i] - min, left[i - 1])
        }

        val right = IntArray(prices.size)
        right[right.lastIndex] = 0
        var max = prices[prices.lastIndex]
        for (i in prices.size - 2 downTo 0) {
            max = Math.max(prices[i], max)
            right[i] = Math.max(max - prices[i], right[i + 1])
        }

        var profit = 0
        for (i in 0 until prices.size) {
            profit = Math.max(profit, left[i] + right[i])
        }
        return profit
    }

}

fun main(args: Array<String>) {
    val data = intArrayOf(3,3,5,0,0,3,1,4)
    val test = `Best Time to Buy and Sell Stock III`()
    println(test.maxProfit(data))
}