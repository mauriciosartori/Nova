package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosest4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2, 3, 5, 8, 9, 11, 21, 29, 1997)
            //val target = 1988
            val target = 19
            println("The input array is ${inputArray.contentToString()} and the target is $target")
            findTheClosest(inputArray, target)
        }

        fun findTheClosest(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            var closestTarget: Int? = null
            while (start <= end ) {
                val middle = (start + end) / 2
                closestTarget = findTheClosestTarget(inputArray, middle, closestTarget, target)
                if (inputArray[middle] > target) {
                    end = middle - 1
                } else if (inputArray[middle] < target) {
                    start = middle + 1
                } else {
                    // Target was found!
                    println("The target was found!")
                    return
                }
            }

            println("Sorry, can't find this number here")
            println("However, the closes number to this is ${inputArray[closestTarget!!]}")
        }

        fun findTheClosestTarget(inputArray: IntArray, middle: Int, closestTarget: Int?, target: Int): Int {
            if (closestTarget == null) {
                return middle
            }
            var newClosest = abs(inputArray[middle] - target)
            var prevClosest = abs(inputArray[closestTarget] - target)
            if (newClosest < prevClosest) {
                return middle
            }
            return closestTarget
        }
    }
}