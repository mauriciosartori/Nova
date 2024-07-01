package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosest3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,5,8,9,11, 21, 29, 1997)
            val target = 1988
            println("The input array is ${inputArray.contentToString()} and the target is $target")
            binarySearchFindClosestTarget(inputArray, target)
        }

        fun binarySearchFindClosestTarget(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            var indexResult = 0
            while (start <= end) {
                val middle = (start + end) / 2
                indexResult = updateResultIndex(inputArray, middle, indexResult, target)
                when {
                    inputArray[middle] > target ->
                        end = middle - 1
                    inputArray[middle] < target ->
                        start = middle + 1
                    else -> {
                        println("Target Found")
                        indexResult = middle
                        break
                    }
                }
            }

            println("The index result is $indexResult and the closest value found was ${inputArray[indexResult]}")
        }

        fun updateResultIndex(inputArray: IntArray, currentIndex: Int, resultIndex:Int, target:Int):Int {
            val currentResult = abs(target - inputArray[currentIndex])
            val indexResult = abs(target - inputArray[resultIndex])
            return when {
                currentResult < indexResult -> currentIndex
                else ->  resultIndex
            }
        }
    }
}