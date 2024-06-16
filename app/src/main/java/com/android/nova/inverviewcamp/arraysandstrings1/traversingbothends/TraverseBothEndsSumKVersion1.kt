package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends
/**
 * 2 Sum Problem:
 * Given a sorted array of integers, find two numbers in the array that sum
 * to a given integer target.
 * For example, if a = [1,2,3,5,6,7] and target = 11, the answer will be 5 and 6.
 */
class TraverseBothEndsSumKVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 3, 5, 6, 7)
            val targetValue = 11
            println("The input array is ${inputArray.contentToString()}")
            findSum(inputArray, targetValue)
        }

        fun findSum(inputArray:IntArray, target: Int) {
            var endIndex = inputArray.size - 1
            var startIndex = 0

            while(startIndex <= endIndex) {
                val currentSum = inputArray[startIndex] + inputArray[endIndex]
                when {
                    currentSum > target -> endIndex--
                    currentSum < target -> startIndex++
                    else -> {
                        println("The two numbers are ${inputArray[startIndex]} and ${inputArray[endIndex]} and the sum is $target")
                        return
                    }
                }
            }
            println("Sorry, there are not numbers that sum $target")
        }
    }
}