package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

/**
 * Level: Hard Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with two trades.
 *
 * A trade is a buy and sell.The two trades cannot overlap.
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class StockPrices2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(8, 14, 2, 5, 7, 3, 9, 5)
            println("The initial array is ${inputArray.contentToString()}")
            maxTheTraiding(inputArray)
        }

        fun maxTheTraiding(inputArray: IntArray) {
            var maxDiff = 0
            var minValue = Int.MAX_VALUE
            var minIndex = 0
            var result = Pair(0,0)

            for (i in inputArray.indices) {
                if (inputArray[i] < minValue) {
                    minValue = inputArray[i]
                    minIndex = i
                }

                val currentMaxDiff = inputArray[i] - minValue
                if (currentMaxDiff > maxDiff) {
                    maxDiff = currentMaxDiff
                    result = Pair(minIndex, i)
                }
            }
            println("Andas! You should buy the stock at ${inputArray[result.first]} and sell it at ${inputArray[result.second]}")
        }
    }
}