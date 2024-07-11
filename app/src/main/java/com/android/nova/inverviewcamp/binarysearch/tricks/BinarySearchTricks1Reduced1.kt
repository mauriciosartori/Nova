package com.android.nova.inverviewcamp.binarysearch.tricks
/**
 * Given an array that is cyclically sorted, find the minimum element.
 * A cyclically sorted array is a sorted array rotated by some number of elements.
 * Assume all elements are unique.
 * For example:A = [4,5,1,2,3], which is just [1,2,3,4,5] rotated by 2
 * Result = index2
 */
class BinarySearchTricks1Reduced1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(4, 5, 6, 1, 2, 3)
            println("The input array is ${inputArray.contentToString()}")
            val result = findSmallestMiniBu(inputArray)
        }

        fun findSmallestMiniBu(inputArray: IntArray) {
            var start = 0
            var end = inputArray.size - 1
            while (start <= end) {
                val middle = (end + start) / 2
                val peak = isThePeak(inputArray, middle)
                if (peak) {
                    print(" The smallest element mini bu is at the index $middle")
                    return
                }
                if ((start + 1) != inputArray.size ) {
                    start++
                }

            }
        }

        fun isThePeak(inputArray: IntArray, middle: Int):Boolean {
            if (middle > 0 && inputArray[middle - 1] >  inputArray[middle]) {
                return true
            }
            return false
        }
    }
}