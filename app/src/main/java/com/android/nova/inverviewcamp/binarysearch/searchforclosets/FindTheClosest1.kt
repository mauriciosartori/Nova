package com.android.nova.inverviewcamp.binarysearch.searchforclosets

import kotlin.math.abs

/**
 * 1. (Level: Easy) Given a sorted array A and a target T, find the target.
 * If the target is not in the array, find the number closest to the target.
 * For example, if A = [2,3,5,8,9,11] and T = 7, return index of 8, i.e. return 3.
 */
class FindTheClosest1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 7
            val inputArray = intArrayOf(2,3,5,8,9,11)
            println("Find the closest element in ${inputArray.contentToString()} and the target is $target")
            findTheClosesElement(inputArray, target)
        }

        fun findTheClosesElement(inputArray: IntArray, target: Int) {
            var distance: Int? = null
            var closestTarget = 0
            for (i in inputArray.indices) {
                val currentDistance = abs(inputArray[i] - target)
                if (distance == null) {
                    distance = currentDistance
                } else {
                    if (currentDistance < distance) {
                        distance = currentDistance
                        closestTarget = inputArray[i]
                    }
                }
            }
            println("The closest number to your target is $closestTarget")
        }
    }
}