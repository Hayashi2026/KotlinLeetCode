package com.hayashi2026.leetcode.dp

class `Best Time to Buy and Sell Stock II` {

    fun maxProfit(prices: IntArray): Int {
        var max = 0
        for (i in 1 until prices.size) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1]
            }
        }
        return max
    }
}

