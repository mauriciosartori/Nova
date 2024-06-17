package com.android.nova.inverviewcamp.binarysearch.withduplicates
/**
 * You are given a sorted array A and a target T. Return the index where T would be placed if inserted in order. For example,
 *
 * A = [1,2,4,5,6,8] and T = 3, return index 2
 * A = [1,2,4,5,6,8] and T = 0, return index 0
 * A = [1,2,4,5,6,8] and T = 4, return index 3.
 */
class BSWithDuplicatesH1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,4,5,6)
            val target = 3
            //val target = 0
            //val target = 4
            println("The input array is ${inputArray.contentToString()}")
            findValueIfAdded(inputArray, target)
        }

        fun findValueIfAdded (inputArray: IntArray, target:Int) {
            var end = inputArray.size - 1
            var start = 0

            while (start <= end) {
                val middle = (start + end) / 2
                if (inputArray[middle] <= target) {
                    if (middle == inputArray.size - 1) {
                        println("The element should be on the index ${inputArray.size}")
                        return
                    }
                    start = middle + 1
                } else {
                    if (middle == 0 || inputArray[middle - 1] <= target) {
                        println("The element should be on the index $middle")
                        return
                    }
                    end = middle - 1
                }
            }
        }
    }
}