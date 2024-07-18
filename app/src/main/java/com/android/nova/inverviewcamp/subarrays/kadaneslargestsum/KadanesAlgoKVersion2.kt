package com.android.nova.inverviewcamp.subarrays.kadaneslargestsum

import kotlin.math.max

/**
 * Given an array of integers that can be both +ve and -ve,
 * find the contiguous subarray with the largest sum.
 * For example:  [1,2,-1,2,-3,2,-5]  -> first 4 elements have the largest sum.
 * Return (0,3)
 */
class KadanesAlgoKVersion2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,-1,2,-3,2,-5)
            println("looking for the max sum the input array is")
            findLargestSum(inputArray)
        }

        fun findLargestSum(inputArray: IntArray) {
            var result = Pair<Int, Int>(0, 0)
            var maxSum = 0
            var currentSum = 0
            for (i in inputArray.indices) {
                if ((inputArray[i] + currentSum) > maxSum) {
                    maxSum = inputArray[i] + currentSum
                }
                currentSum += inputArray[i]
            }
            println("The max sum is $maxSum")
        }
    }
}