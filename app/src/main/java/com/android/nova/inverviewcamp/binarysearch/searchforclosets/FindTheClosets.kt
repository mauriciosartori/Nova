package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosets {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,5,8,9,11)
            val target = 6
            println("The input array is ${inputArray.contentToString()}")
            findClosestValue(inputArray, target)
        }
        fun findClosestValue(inputArray: IntArray, target:Int) {
            var start = 0
            var end = inputArray.size - 1
            var resultIndex: Int? = null
            while (start <= end) {
                val middle = (start + end) / 2
                resultIndex = recordClosestNumber(inputArray, middle, resultIndex, target)
                when {
                    inputArray[middle] > target -> end = middle - 1
                    inputArray[middle] < target -> start = middle + 1
                    else -> {
                        print("The resul is in the index $middle and the value is ${inputArray[middle]}")
                        return
                    }
                }
            }
            if (resultIndex != null) {
                print("The closest index is to the target $target is $resultIndex meaning ${inputArray[resultIndex]}")
                return
            }
            print("Can't find the value, sorry!")
        }

        fun recordClosestNumber(inputArray: IntArray, middle: Int, resultIndex: Int?, target: Int):Int {
            return if (resultIndex == null) {
                middle
            } else {
                val currentResultDiffTarget = abs(inputArray[resultIndex] - target)
                val middleDiffTarget = abs(inputArray[middle] - target)
                if (currentResultDiffTarget > middleDiffTarget) {
                    middle
                } else {
                    resultIndex
                }
            }
        }
    }
}