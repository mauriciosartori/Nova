package com.android.nova.inverviewcamp.subarrays.kadaneslargestsum

import kotlin.math.max

/**
 * Given an array of integers that can be both +ve and -ve,
 * find the contiguous subarray with the largest sum.
 * For example:  [1,2,-1,2,-3,2,-5]  -> first 4 elements have the largest sum.
 * Return (0,3)
 */
class KadanesAlgoKVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,-1,2,-3,2,-5)
            println("The input array is")
            findLargestSum(inputArray)
        }

        fun findLargestSum(inputArray: IntArray) {
            var currentValue = 0
            var maxValue = 0
            var maxIndex = 0
            for (i in inputArray.indices) {
                    currentValue += inputArray[i]
                  if (currentValue > maxValue) {
                      maxValue = currentValue
                      maxIndex = i
                  }

            }

            println("The max value sum is $maxValue and the max index is $maxIndex")
        }
    }
}