package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

import kotlin.math.max
import kotlin.math.min

/**
 * Level: Hard Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with two trades.
 *
 * A trade is a buy and sell.The two trades cannot overlap.
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class StockPrices {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(8, 14, 2, 5, 7, 3, 9, 5)
            println("The initial array is ${inputArray.contentToString()}")
            maxTheTraiding(inputArray)
        }

        fun maxTheTraiding(inputArray: IntArray) {
            var minSoFar = Integer.MAX_VALUE
            var maxDiff = 0


            // Tricky part Pay attention for the love of God!
            val bestTillArray = IntArray(inputArray.size)

            for (i in inputArray.indices) {
                minSoFar = min(minSoFar, inputArray[i])

                if (inputArray[i] - minSoFar > maxDiff) {
                    maxDiff = inputArray[i] - minSoFar
                }

                // Saving the max so far for every iteration
                bestTillArray[i] = maxDiff
            }
            println("The max amount in a single transaction is $maxDiff")
            println("The best till array looks like this ${bestTillArray.contentToString()}")

            // Another tricky part, let's pay attention for the love of God!!
            val bestFromArray = IntArray(inputArray.size)
            var maxSoFar = Integer.MIN_VALUE
            maxDiff = 0

            for (i in inputArray.size - 1 downTo 0) {
                maxSoFar = max(maxSoFar, inputArray[i])
                maxDiff = max(maxDiff, maxSoFar- inputArray[i])
                bestFromArray[i] = maxDiff
            }
            println("The RESULT for best from array looks like this ${bestFromArray.contentToString()}")

            // Here comes another tricky part

            var maxTwoTrades = 0
            for (i in inputArray.indices) {
                val maxSecondTrade = if (i + 1 < inputArray.size) bestFromArray[i + 1] else 0
                maxTwoTrades = max(maxTwoTrades, bestTillArray[i] + maxSecondTrade)
            }

            println("At the end of the day the result is $maxTwoTrades")
        }
    }
}