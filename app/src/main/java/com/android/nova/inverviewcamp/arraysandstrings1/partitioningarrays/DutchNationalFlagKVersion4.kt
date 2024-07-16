package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays
/**
 * Given an array of integers A and a pivot, rearrange A in the following order:
 * [Elements less than pivot, elements equal to pivot, elements greater than pivot]
 *
 * For example, if A = [5,2,4,4,6,4,4,3] and pivot = 4 -> result = [3,2,4,4,4,4,6,5]
 *
 * Note: the order within each section doesn't matter.
 */
class DutchNationalFlagKVersion4 {
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
            var end = inputArray.size - 1
            var pivot = 0
            while (pivot <= end) {
                when {
                    inputArray[pivot] < pivotValue -> {
                        swap(inputArray, pivot, start)
                        start++
                        pivot++
                    }
                    inputArray[pivot] > pivotValue -> {
                        swap(inputArray, pivot, end)
                        end--
                    } else -> {
                        // The pivot is the same
                        pivot++
                    }
                }
            }
            println("The array result is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, a: Int, b:Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }

    }
}