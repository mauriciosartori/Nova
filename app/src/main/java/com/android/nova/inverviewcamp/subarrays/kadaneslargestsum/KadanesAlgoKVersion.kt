package com.android.nova.inverviewcamp.subarrays.kadaneslargestsum

import kotlin.math.max

/**
 * Given an array of integers that can be both +ve and -ve,
 * find the contiguous subarray with the largest sum.
 * For example:  [1,2,-1,2,-3,2,-5]  -> first 4 elements have the largest sum.
 * Return (0,3)
 */
class KadanesAlgoKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,-1,2,-3,2,-5)
            println("The input array is")
            findLargestSum(inputArray)
        }

        fun findLargestSum(inputArray: IntArray) {
            var maxSumSoFar = inputArray[0]
            var result = inputArray[0]
            for (i in 1..inputArray.indices.last) {
                maxSumSoFar = max(inputArray[i], inputArray[i] + maxSumSoFar)
                result = max(result, maxSumSoFar)
            }
            println("The highest result is $result")
        }
    }
}