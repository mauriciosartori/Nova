package com.android.nova.inverviewcamp.binarysearch.withduplicates
/**
 * 1. (Level: Easy) Given a sorted array that can contain duplicates,
 * find the first occurrence of a target element T.
 *
 * For example, if A = [2,3,4,4,5,6] and T = 4, return index 2.
 */
class BinarySearchWithDuplicates1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(-1,0,1,2,3,4,4,4,4,5,6,7,8,21,29)
            val target = 4
            //val target = 17
            println("The input array is ${inputArray.contentToString()}")
            findFirstOcurrenceBinarySearch(inputArray, target)
        }

        fun findFirstOcurrenceBinarySearch(inputArray: IntArray, target:Int) {
            var start = 0
            var end = inputArray.size - 1

            while (start <= end) {
                val middle = (start + end) / 2

                if (inputArray[middle] > target) {
                    end = middle - 1
                } else if (inputArray[middle] < target) {
                    start = middle + 1
                } else {
                    // Check if there is one more before
                    if (middle - 1 > 0 && inputArray[middle - 1] == target ) {
                        end = middle - 1
                    } else {
                        // Element found at this index
                        println("Element found at index $middle")
                        return
                    }
                }
            }
        }
    }
}