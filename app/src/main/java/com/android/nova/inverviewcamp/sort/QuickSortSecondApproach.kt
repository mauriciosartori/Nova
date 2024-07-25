package com.android.nova.inverviewcamp.sort
/**
 * Quick Sort using traditional approach
 */
class QuickSortSecondApproach {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,9,7,4,2021,6,5,3,3,1997)
            println("The input array is ${inputArray.joinToString(", ")}")
            quickSort(inputArray, 0, inputArray.size - 1)
            println("After calling quick sort the input array is ${inputArray.joinToString(", ")}")
        }

        fun quickSort(inputArray: IntArray, start: Int, end: Int) {
            // Base case
            if (start > end) {
                return
            }

            val pivot = getPivot(inputArray, start, end)
            quickSort(inputArray, start, pivot - 1)
            quickSort(inputArray, pivot + 1, end)
        }

        fun getPivot(inputArray: IntArray, start: Int, end: Int): Int {
            var i = start - 1
            var pivotIndex = end
            for (j in start..end) {
                if (inputArray[j] < inputArray[pivotIndex]) {
                    i++
                    swap(inputArray, i, j)
                }
            }
            swap(inputArray, i + 1, end)
            return i + 1
        }

        fun swap(inputArray: IntArray, a:Int, b:Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}