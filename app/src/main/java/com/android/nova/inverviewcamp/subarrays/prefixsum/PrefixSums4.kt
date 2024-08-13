package com.android.nova.inverviewcamp.subarrays.prefixsum
/**
 * Given an array of integers, find the contiguous subarray
 * that sums to 0.
 * The array can contain both negative and positive integers.
 *
 * For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */
class PrefixSums4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2, 4, -2, 1, -3, 5, -3)
            println("The input array is ${inputArray.contentToString()} andas!")
            findSubarrayToZero(inputArray)
        }

        fun findSubarrayToZero(inputArray: IntArray) {
            var currentSum = 0
            var mapSumIndex = HashMap<Int, Int>()
            for (i in inputArray.indices) {
                 currentSum = inputArray[i] + currentSum

                if (mapSumIndex.containsKey(currentSum)){
                    val initIndex = mapSumIndex.getOrDefault(currentSum, 0) + 1
                    println("The initial index is $initIndex and final index is $i")
                    println("So the array at the end of the days is ${inputArray.sliceArray(initIndex..i).joinToString(", ")}")
                    break
                }
                mapSumIndex[currentSum] = i
            }

        }
    }
}