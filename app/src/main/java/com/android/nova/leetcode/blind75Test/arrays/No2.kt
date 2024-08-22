package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            maxProfit(intArrayOf(7,1,5,3,6,4))
            println("")
        }

        fun maxProfit(prices: IntArray): Int {
            var minValue = Int.MAX_VALUE//Smallest value so far
            var maxEarnings = 0
            for (i in prices.indices) {
                val currentPrice = prices[i]

                if (currentPrice < minValue) {
                    minValue = currentPrice
                }

                if (currentPrice - minValue > maxEarnings) {
                    maxEarnings = currentPrice - minValue
                }
            }
            return maxEarnings
        }
    }
}