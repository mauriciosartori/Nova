package com.android.nova.inverviewcamp.subarrays.prefixsum
/**
 * Given an array of integers, find the contiguous subarray
 * that sums to 0.
 * The array can contain both negative and positive integers.
 *
 * For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */
class PrefixSums1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,4,-2,1,-3,5,-3)
            println("The input array is ${inputArray.contentToString()}")
            findSubarrayToZero(inputArray)
        }

        fun findSubarrayToZero(inputArray: IntArray) {
            val mapPrevValues = HashMap<Int, Int>()
            var startIndex = 0
            var endIndex = 0
            var currentSum = 0

            for (i in inputArray.indices) {
                currentSum += inputArray[i]
                if (mapPrevValues.containsKey(currentSum)) {
                    startIndex = mapPrevValues.getOrDefault(currentSum, 0) + 1
                    endIndex = i
                    break
                }

                mapPrevValues[currentSum] = i
            }
            println("The subarray result is ${inputArray.sliceArray(startIndex..endIndex).contentToString()}")
        }
    }
}