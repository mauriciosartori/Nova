package com.android.nova.inverviewcamp.subarrays.kadaneslargestsum

import kotlin.math.max

/**
 * Given an array of integers that can be both +ve and -ve,
 * find the contiguous subarray with the largest sum.
 * For example:  [1,2,-1,2,-3,2,-5]  -> first 4 elements have the largest sum.
 * Return (0,3)
 */
class KadanesAlgoKVersion3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,-1,2,-3,2,-5)
            println("looking for the max sum the input array is")
            findLargestSum(inputArray)
        }

        fun findLargestSum(inputArray: IntArray) {
            var addedSum = 0
            var currentSum = 0
            for (i in inputArray.indices) {
                currentSum = inputArray[i] + currentSum
                if (currentSum > addedSum) {
                    addedSum = currentSum
                }
            }
            println("The largest sum is $addedSum")
        }

    }
}