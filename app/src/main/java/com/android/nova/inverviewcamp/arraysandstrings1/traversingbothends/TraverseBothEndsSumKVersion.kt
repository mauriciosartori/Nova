package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends
/**
 * 2 Sum Problem:
 * Given a sorted array of integers, find two numbers in the array that sum
 * to a given integer target.
 * For example, if a = [1,2,3,5,6,7] and target = 11, the answer will be 5 and 6.
 */
class TraverseBothEndsSumKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,5,6,7)
            val targetValue = 11
            println("The input array is ${inputArray.contentToString()}")
            findSum(inputArray, targetValue)
        }

        fun findSum(inputArray: IntArray, targetValue: Int) {
            var startIndex = 0
            var endIndex = inputArray.size - 1

            while(startIndex < endIndex) {
                val currentSum = inputArray[startIndex] + inputArray[endIndex]
                if (currentSum < targetValue) {
                    startIndex++
                } else if (currentSum > targetValue) {
                    endIndex--
                } else {
                    println("The result of the sums are the values ${inputArray[startIndex]}  and ${inputArray[endIndex]}")
                    return
                }
            }
            println("Sorry there is not numbers to sum the whole thing")
        }
    }
}