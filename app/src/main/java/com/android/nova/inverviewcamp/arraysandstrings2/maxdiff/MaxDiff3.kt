package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

/**
 * Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with one trade. A trade is a buy and sell.
 *
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class MaxDiff3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(8, 14, 2, 5, 7, 3, 9, 5)
            println("The input array is ${inputArray.contentToString()}")
            findBestTrade(inputArray)
        }

        fun findBestTrade(inputArray: IntArray) {
            var maxDiff = 0
            var minValue = Integer.MAX_VALUE
            var minIndex = 0
            var result: Pair<Int,Int> = Pair(0, 0)
            for (i in inputArray.indices) {
                if (inputArray[i] < minValue) {
                    minValue = inputArray[i]
                    minIndex = i
                }
                val currentDiff = inputArray[i] - minValue
                if (currentDiff > maxDiff) {
                    maxDiff = currentDiff
                    result = Pair(minIndex, i)
                }
            }
            println("At the end of the day the number to buy is ${inputArray[result.first]} and the position to sell is ${inputArray[result.second]}")
        }
    }
}