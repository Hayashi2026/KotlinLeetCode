package com.hayashi2026.leetcode.dp

class `Best Time to Buy and Sell Stock` {

    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var minPrice = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            }
        }
        return maxProfit
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1, 2)
    val test = `Best Time to Buy and Sell Stock`()
    println(test.maxProfit(data))
}