package com.android.nova.inverviewcamp.subarrays.prefixsum

/**
 * Given an array of positive and negative integers, find a subarray whose sum equals X.
 * For example: Input = [2,4,-2,1,-3,5,-3], X = 5 --> Result = [2,4,-2,1]
 */
class PrefixSumsH1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,4,-2,1,-3,5,-3)
            val target = 5
            println("The input array is ${inputArray.contentToString()}")
            findSubarraySumingTarget(inputArray, target)
        }

        fun findSubarraySumingTarget(inputArray: IntArray, target: Int) {
            var sum = 0
            for (i in inputArray.indices) {
                sum += inputArray[i]
                if (sum == target) {
                    println("The subarray that will sum $target is ${inputArray.sliceArray(0..i).contentToString()}")
                }
            }
        }
    }
}