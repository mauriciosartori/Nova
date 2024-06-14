package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends

import kotlin.math.abs

/**
 * Given an array of integers, find the continuous subarray,
 * which when sorted, results in the entire array being sorted.
 * For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
 */
class TraverseBothEndsh2KVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(0,2,3,1,8,6,9)
            println("The input array is ${inputArray.contentToString()}")
            findSubArray(inputArray)
        }

        fun findSubArray(inputArray: IntArray) {
            var dipIndex = -1;
            var bumpIndex = -1;

            // Find the dip
            for (i in inputArray) {
                if (i > 0 && inputArray[i] < inputArray[i - 1]) {
                    dipIndex = i - 1
                    break
                }
            }

            // Find the bump
            for (i in inputArray.size - 1 downTo 1 ) {
                println("The condition was ${inputArray[i]} < ${inputArray[i - 1]} ")
                if (inputArray[i] < inputArray[i - 1]) {
                    println("yes")
                    bumpIndex = i
                    break
                }
            }
            println("The indexes are dip index $dipIndex and bump index $bumpIndex")
            println("The array that needs to be sorted is ${inputArray.sliceArray(dipIndex .. bumpIndex).contentToString()}")
        }

    }
}