package com.android.nova.inverviewcamp.binarysearch.withduplicates
/**
 * 1. (Level: Easy) Given a sorted array that can contain duplicates,
 * find the first occurrence of a target element T.
 *
 * For example, if A = [2,3,4,4,5,6] and T = 4, return index 2.
 */
class BinarySearchWithDuplicates {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,4,4,4,4,5,6,7,8,21,29)
            val target = 4
            //val target = 17
            println("The input array is ${inputArray.contentToString()}")
            findFirstOcurrenceBinarySearch(inputArray, target)
        }

        fun findFirstOcurrenceBinarySearch(inputArray: IntArray, target: Int) {
            var start = 0
            var end = inputArray.size - 1
            while(start <= end) {
                val middle = (start + end) /2
                when {
                    inputArray[middle] > target || ( inputArray[middle] == target && middle > 0 && inputArray[middle - 1] == target)  -> end = middle - 1
                    inputArray[middle] < target -> start = middle + 1
                    else -> {
                        println("The target $target was found at $middle")
                        return
                    }
                }
            }
            println("The value wasn't found")
        }
    }
}