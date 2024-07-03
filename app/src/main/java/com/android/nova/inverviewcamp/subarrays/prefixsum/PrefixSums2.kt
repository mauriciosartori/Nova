package com.android.nova.inverviewcamp.subarrays.prefixsum
/**
 * Given an array of integers, find the contiguous subarray
 * that sums to 0.
 * The array can contain both negative and positive integers.
 *
 * For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */
class PrefixSums2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,4,-2,1,-3,5,-3)
            println("The input array is ${inputArray.contentToString()} andas!")
            findSubarrayToZero(inputArray)
        }

        fun findSubarrayToZero(inputArray: IntArray) {
            var currentSum = 0
            val mapOccurrences:MutableMap<Int, Int> = mutableMapOf()
            for (i in inputArray.indices) {
                currentSum += inputArray[i]

                if (mapOccurrences.containsKey(currentSum)) {
                    val startIndex = mapOccurrences.getOrDefault(currentSum,0)
                    println("The subarray that sums zero is ${inputArray.sliceArray(startIndex + 1.. i).contentToString()}")
                    break
                }
                mapOccurrences[currentSum] = i
            }
        }
    }
}