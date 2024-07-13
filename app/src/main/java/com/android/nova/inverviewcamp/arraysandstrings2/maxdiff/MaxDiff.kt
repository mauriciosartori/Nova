package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

/**
 * Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with one trade. A trade is a buy and sell.
 *
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class MaxDiff {
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
                if (inputArray[i] < minSoFar ) {
                    minSoFar = inputArray[i]
                }
                val currentDiff = inputArray[i] - minSoFar
                if (currentDiff > maxSoFar) {
                    maxSoFar = currentDiff
                    println("The resul is a subs between ${inputArray[i]} and $minSoFar")
                }
            }
            println("In this case the max amount of money we can make is $maxSoFar")
        }
    }
}