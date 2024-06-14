package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends
/**
 *  Given an array, reverse the order of its elements.
 *  For example, [3,5,2,5,2,3,9] → [9,3,2,5,2,5,3]
 */
class TraverseBothEndsKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(3,5,2,5,2,3,9)
            println("The input array is ${inputArray.contentToString()}")
            reverseOrder(inputArray)
        }

        fun reverseOrder(inputArray: IntArray) {
            var startIndex = 0
            var endIndex = inputArray.size - 1
            while (startIndex < endIndex) {
                swap(inputArray, startIndex, endIndex)
                startIndex++
                endIndex--
            }
            println("The result is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}