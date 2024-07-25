package com.android.nova.inverviewcamp.sort
/**
 * Implement quick sort
 */
class QuickSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,9,7,4,2021,6,5,3,3,1997)
            callQuickSort(inputArray)
        }

        fun callQuickSort(inputArray: IntArray) {
            println("The input is ${inputArray.joinToString(", ")}")
            quickSort(inputArray, 0, inputArray.size - 1 )
            println("And the output after the sort is  ${inputArray.joinToString(", ")}")
        }

        fun callDutchNationalFlag(inputArray: IntArray) {
            println("Implementing Dutch National Flag First")
            dutchNationalFlag(inputArray, 0, inputArray.size - 1, 5)
            println("Now let's work on some quick sort")
        }

        fun dutchNationalFlag(inputArray: IntArray, start: Int, end: Int, pivotIndex: Int): Pair<Int, Int> {
            val pivotValue = inputArray[pivotIndex]

            var low = start - 1
            var mid = start - 1
            var high = end + 1

            while (mid + 1 < high) {
                if (inputArray[mid + 1] > pivotValue) {
                    swap(inputArray, high - 1, mid + 1)
                    high--
                } else if (inputArray[mid + 1] == pivotValue) {
                    mid++
                } else {
                    swap(inputArray, mid + 1, low + 1)
                    mid++
                    low++
                }
            }
            //println("The result is low $low and high $high")
            //println("Now the array after DNF looks like this ${inputArray.joinToString(", ")}")
            return Pair(low, high)
        }

        fun quickSort(inputArray: IntArray, start:Int, end:Int) {
            // base cases
            if (start < 0 || end >= inputArray.size || start >= end) {
                return
            }
            val pivot = start + (0 until (end - start + 1)).random()
            val points = dutchNationalFlag(inputArray, start, end, pivot)
            quickSort(inputArray, start, points.first)
            quickSort(inputArray, points.second, end)
        }

        private fun swap(inputArray: IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}