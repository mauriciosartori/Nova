package com.android.nova.inverviewcamp.binarysearch.singleversion

/**
 * Given a sorted array, search for a target item.
 * For example array [1,3,5,6,9,11,14,17,1,21] my target will be 9 and then try with 15
 */
class SingleBinarySearch1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,3,5,6,9,11,14,17,19,21)
            val target = 21
            println("Looking for a target item $target in ${inputArray.contentToString()}")
            lookingForTarget(inputArray, target)
        }

        fun lookingForTarget(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            while (start <= end) {
                val middle = (start + end) / 2
                if (inputArray[middle] < target) {
                    start = middle + 1
                } else if (inputArray[middle] > target) {
                    end = middle - 1
                } else {
                    println("The target was found at position $middle")
                    return
                }
            }
            println("Target not found")
        }
    }
}