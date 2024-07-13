package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

import kotlin.math.max
import kotlin.math.min


/**
 * Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with one trade. A trade is a buy and sell.
 *
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class MaxDiff2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(8, 14, 2, 5, 7, 3, 9, 5)
            println("The input array is ${inputArray.contentToString()}")
            findBestTrade(inputArray)
        }

        fun findBestTrade(inputArray: IntArray) {
            var minSoFar = Integer.MAX_VALUE
            var maxSoFar = 0

            for (i in inputArray.indices) {
                minSoFar = min(minSoFar, inputArray[i])
                maxSoFar = max(maxSoFar, inputArray[i] - minSoFar)
            }
            println("Test version....In this case the max amount of money we can make is $maxSoFar")
        }
    }
}