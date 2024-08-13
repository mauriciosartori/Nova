package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 * Given an array with n marbles colored Red, White or Blue,
 * sort them so that marbles of the same color are adjacent,
 * with the colors in the order Red, White and Blue.
 * Assume the colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
 * For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
 */
class DutchNationalMarblesKVersion3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 0, 1, 2, 1, 0, 1, 2)
            println("The input array is ${inputArray.contentToString()}")
            println("Question here, can you do a different arrangement? Answer is no")
            sortColors(inputArray)
            println("The result of this thingy is ${inputArray.contentToString()}")
        }

        fun sortColors(inputArray: IntArray) {
            var start = 0
            var end = inputArray.size - 1
            var pivot = 0

            while (start <= end) {
                if (inputArray[start] == 2 ) {
                    // compare if is part of the low
                    swap(inputArray, start, end)
                    end--
                } else if (inputArray[start] == 0) {
                    // compare if is pivot
                    swap(inputArray, pivot, start)
                    start++
                    pivot++
                } else {
                    // compare if is 2
                    start++
                }
            }
        }

        fun swap(inputArray: IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}