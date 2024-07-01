package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays
/**
 * Given an array of integers A and a pivot, rearrange A in the following order:
 * [Elements less than pivot, elements equal to pivot, elements greater than pivot]
 *
 * For example, if A = [5,2,4,4,6,4,4,3] and pivot = 4 -> result = [3,2,4,4,4,4,6,5]
 *
 * Note: the order within each section doesn't matter.
 */
class DutchNationalFlagKVersion3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,2,4,4,6,4,4,3)
            val pivot = 4
            println("Version3: Rearraging the input array ${inputArray.contentToString()} and its pivot is $pivot")
            dutchFlag(inputArray, pivot)
        }

        fun dutchFlag(inputArray: IntArray, pivotValue: Int) {
            var start = 0
            var pivot = 0
            var end = inputArray.size - 1
            while (pivot <= end) {
                if (inputArray[pivot] < pivotValue ) {
                    swap(inputArray, start, pivot)
                    start++
                    pivot++
                } else if (inputArray[pivot] > pivotValue ) {
                    swap(inputArray, pivot, end)
                    end--
                } else {
                    // the current value in the pivot is equals the the pivot
                    // Therefore increase the pivot
                    pivot++
                }
            }

            println("At the end of the day the result is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, pivot: Int, end:Int) {
            val temp = inputArray[pivot]
            inputArray[pivot] = inputArray[end]
            inputArray[end] = temp
        }
    }
}