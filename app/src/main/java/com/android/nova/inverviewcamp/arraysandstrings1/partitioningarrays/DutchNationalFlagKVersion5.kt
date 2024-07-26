package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays
/**
 * Given an array of integers A and a pivot, rearrange A in the following order:
 * [Elements less than pivot, elements equal to pivot, elements greater than pivot]
 *
 * For example, if A = [5,2,4,4,6,4,4,3] and pivot = 4 -> result = [3,2,4,4,4,4,6,5]
 *
 * Note: the order within each section doesn't matter.
 */
class DutchNationalFlagKVersion5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5, 2, 4, 4, 6, 4, 4, 3)
            val pivot = 4
            println("Version3: Rearraging the input array ${inputArray.contentToString()} and its pivot is $pivot")
            dutchFlag(inputArray, pivot)
            println("The result is ${inputArray.joinToString(", ")}")
        }

        fun dutchFlag(inputArray: IntArray, pivotValue: Int) {
            var lowBoundary = 0
            var highBoundary = inputArray.size - 1
            var i = 0
            while (i <= highBoundary) {
                when{
                    inputArray[i] < pivotValue -> {
                        swap(inputArray, i, lowBoundary)
                        lowBoundary++
                        i++
                    }
                    inputArray[i] > pivotValue -> {
                        swap(inputArray, i, highBoundary)
                        highBoundary--
                    }
                    else -> {
                        i++
                    }
                }
            }
        }

        fun swap (inputArray:IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}