package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 * Given an array with n marbles colored Red, White or Blue,
 * sort them so that marbles of the same color are adjacent,
 * with the colors in the order Red, White and Blue.
 * Assume the colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
 * For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
 */
class DutchNationalMarblesKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,0,1,2,1,0,1,2)
            println("The input array is ${inputArray.contentToString()}")
            sortColors(inputArray)
        }

        fun sortColors(inputArray: IntArray) {
            val pivot = 1
            var lowBoundary = 0
            var highBoundary = inputArray.size - 1
            var i = 0
            while (i <= highBoundary) {
                when{
                    inputArray[i] < pivot -> {
                        swap(inputArray, i, lowBoundary)
                        lowBoundary++
                        i++
                    }
                    inputArray[i] > pivot -> {
                        swap(inputArray, i, highBoundary)
                        highBoundary--
                    }
                    else -> {
                        i++
                    }
                }
            }
            println("The Result is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, a: Int, b:Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}