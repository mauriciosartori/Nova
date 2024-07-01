package com.android.nova.inverviewcamp.binarysearch.singleversion

/**
 * Given a sorted array, search for a target item.
 * For example array [1,3,5,6,9,11,14,17,1,21] my target will be 9 and then try with 15
 */
class SingleBinarySearch2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,3,5,6,9,11,14,17,19,21)
            val target = 15
            println("V2 Searching for $target at the array ${inputArray.contentToString()}")
            binarySearch(inputArray, target)
        }

        fun binarySearch(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1

            while (start <= end) {
                val middle = (start + end) / 2
                when {
                    inputArray[middle] > target -> {
                        end = middle - 1
                    }
                    inputArray[middle] < target -> {
                        start = middle + 1
                    } else -> {
                        println("Element ${inputArray[middle]} was found at $middle ")
                        return;
                    }
                }
            }
            println("The element is not present in this array")
        }
    }
}