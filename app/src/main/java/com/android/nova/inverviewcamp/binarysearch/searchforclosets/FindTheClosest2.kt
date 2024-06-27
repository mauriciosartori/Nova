package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosest2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,5,8,19,110)
            val target = 11

            println("The input array is ${inputArray.contentToString()} and the target is $target")
            findClosestValue(inputArray, target)
        }

        fun findClosestValue(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            var result: Int? = null
            while (start <= end) {
                val middle = (start + end) / 2
                result = updateResult(inputArray, target, result, middle)
                if (inputArray[middle] < target) {
                    start = middle + 1
                } else if (inputArray[middle] > target) {
                    end = middle - 1
                } else {
                    println("Result actually found")
                    return
                }
            }
            println("The closes value to this madre is $result")
        }

        fun updateResult(inputArray: IntArray, target: Int, result: Int?, middle: Int): Int {
            val currentResult = abs(inputArray[middle] - target)
            if(result == null) {
                return middle
            }
            val prevResult = abs(inputArray[result] - target)
            if (currentResult < prevResult) {
                return middle
            } else return result
        }
    }
}