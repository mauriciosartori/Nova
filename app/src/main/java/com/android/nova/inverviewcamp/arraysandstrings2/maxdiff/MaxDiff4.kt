package com.android.nova.inverviewcamp.arraysandstrings2.maxdiff

/**
 * Given a list of stock prices for a company,
 * find the maximum amount of money you can make
 * with one trade. A trade is a buy and sell.
 *
 * For example [8, 14, 2, 5, 7, 3, 9, 5]
 * the pick to buy and sell would be 2 and 7
 */
class MaxDiff4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(8, 14, 2, 5, 7, 3, 9, 5)
            println("The input array is ${inputArray.contentToString()}")
            findBestTrade(inputArray)
        }

        fun findBestTrade(inputArray: IntArray) {
            var maxDiff = 0
            var minDiff = Integer.MAX_VALUE
            var minIndex = 0
            var result: Pair<Int, Int> = Pair(0,0)

            for (i in inputArray.indices) {
                if (inputArray[i] < minDiff) {
                    minDiff = inputArray[i]
                    minIndex = i
                }
                val currentDiff = inputArray[i] - minDiff
                if (currentDiff > maxDiff) {
                    maxDiff = currentDiff
                    result = Pair(minIndex, i)
                }
            }
            println("The authentic result is from ${result.first} to ${result.second}")
            println("In other words buy at ${inputArray[result.first]} and sell at ${inputArray[result.second]}")
        }
    }
}