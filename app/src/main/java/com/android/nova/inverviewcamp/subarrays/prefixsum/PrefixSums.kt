package com.android.nova.inverviewcamp.subarrays.prefixsum

/**
 * Given an array of integers, find the contiguous subarray
 * that sums to 0.
 * The array can contain both negative and positive integers.
 *
 * For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */
class PrefixSums {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,4,-2,1,-3,5,-3)
            println("The input array is ${inputArray.contentToString()}")
            val result = findSubArraySumsZero(inputArray)
            println("Then the result is  ${result.first} and the second is ${result.second} so the" +
                    " full array looks like ${inputArray.sliceArray(result.first..result.second).contentToString()}")
        }
        fun findSubArraySumsZero(inputArray: IntArray):Pair<Int, Int> {
            // Will contain sum + position
            val occurrencesMap = mutableMapOf<Int, Int>()
            var sum = 0

            for (i in inputArray.indices) {
                val currentValue = inputArray[i]
                sum +=currentValue
                if (sum == 0) {
                    return Pair(0, i)
                }
                if (occurrencesMap.containsKey(sum)) {
                    val prevIndex = occurrencesMap.getOrDefault(sum, 0) + 1
                    return Pair(prevIndex, i)
                }
                occurrencesMap[sum] = i
            }
            return Pair(0, 0)
        }
    }
}