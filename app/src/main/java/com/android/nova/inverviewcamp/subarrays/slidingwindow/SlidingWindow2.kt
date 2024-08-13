package com.android.nova.inverviewcamp.subarrays.slidingwindow

/**
 * Given an array of positive integers, find the contiguous subarray that sums to a given number X.
 * For example, input = [1,2,3,5,2] and X=8, Result = [3,5]
 */
class SlidingWindow2 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,5,2, 19)
            val target = 8
            println("The input array looking to sum $target is ${inputArray.contentToString()}")
            findTargetSum(inputArray, target)
        }

        fun findTargetSum(inputArray: IntArray, target: Int) {
            var start = 0
            var end = 0
            var currentSum = 0

            while (start < inputArray.size) {
                if (currentSum == target) {
                    break
                } else if (currentSum < target) {
                    currentSum = currentSum + inputArray[end]
                    end++
                } else {
                    currentSum = currentSum - inputArray[start]
                    start++
                }
            }
            println("At the end of the day we have the target found at $start and $end and the sum from ${inputArray.sliceArray(start.. end).joinToString (",  ")}")
        }

    }
}