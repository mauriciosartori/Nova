package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends

import kotlin.math.abs

/**
 * Given a sorted array in non-decreasing order,
 * return an array of squares of each number,
 * also in non-decreasing order. For example:
 * [-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
 * How can you do it in O(n) time?
 */
class TraverseBothEndsh1KVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(-4,-2,-1,0,3,5)
            println("The input array is ${inputArray.contentToString()}")
            convertArrayToSquares(inputArray)
        }
        fun convertArrayToSquares(inputArray: IntArray) {
            var startIndex = 0
            var endIndex = inputArray.size - 1
            val outputArray = IntArray(inputArray.size)
            var outputIndex = inputArray.size - 1

            while(startIndex < endIndex) {
                var currentResult = 0
                   when {
                       abs(inputArray[startIndex]) < abs(inputArray[endIndex]) ->{
                           currentResult = inputArray[endIndex] * inputArray[endIndex]
                           endIndex--
                       }
                       abs(inputArray[startIndex]) > abs(inputArray[endIndex]) -> {
                           currentResult = inputArray[startIndex] * inputArray[startIndex]
                           startIndex++}
                   }
                outputArray[outputIndex--] = currentResult
            }
            println("The result array is ${outputArray.contentToString()}")
        }
    }
}