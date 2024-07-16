package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosest5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2, 3, 5, 8, 9, 11, 21, 29, 1997)
            val target = 1988
            //val target = 19
            println("The input array is ${inputArray.contentToString()} and the target is $target")
            findTheClosest(inputArray, target)
        }

        fun findTheClosest(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            var closestValue = Integer.MAX_VALUE

            while (start <= end) {
                val middle = (start + end) / 2
                closestValue = updateClosestValue(inputArray, inputArray[middle], closestValue, target)
                if (inputArray[middle] > target) {
                    end = middle - 1
                } else if (inputArray[middle] < target) {
                    start = middle + 1
                } else {
                    // The value was found
                    println("Value found at the position $middle")
                    return
                }
            }
            println("The target wasn't found this time")
            println("BUT it seems like the closest value we can get is $closestValue")
        }

        fun updateClosestValue(inputArray: IntArray, prevClosestValue: Int, currentClosestValue: Int, target:Int):Int {
            if (abs(target - currentClosestValue) < abs(target - prevClosestValue)) {
                return currentClosestValue
            }
            return prevClosestValue
        }
    }
}