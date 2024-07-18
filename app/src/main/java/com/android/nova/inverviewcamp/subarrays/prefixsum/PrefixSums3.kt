package com.android.nova.inverviewcamp.subarrays.prefixsum
/**
 * Given an array of integers, find the contiguous subarray
 * that sums to 0.
 * The array can contain both negative and positive integers.
 *
 * For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */
class PrefixSums3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2, 4, -2, 1, -3, 5, -3)
            println("The input array is ${inputArray.contentToString()} andas!")
            findSubarrayToZero(inputArray)
        }

        fun findSubarrayToZero(inputArray: IntArray) {
            var currentSum = 0
            var result = Pair(0,0)
            val mapSums = HashMap<Int, Int>() // sum | index
            for (i in inputArray.indices) {
                currentSum = inputArray[i] + currentSum
                if (mapSums.get(currentSum) != null) {
                    val startIndex =mapSums.getOrDefault(currentSum, 0)
                    result = Pair(startIndex + 1, i )
                    break
                }
                mapSums[currentSum] = i
            }

            println("The result is to in this subarray ${inputArray.sliceArray(result.first..result.second).contentToString()}")
        }

    }
}