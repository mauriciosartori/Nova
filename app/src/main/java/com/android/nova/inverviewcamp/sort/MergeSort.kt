package com.android.nova.inverviewcamp.sort
/**
 * Implement a classic merge sort
 */
class MergeSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,9,7,4,2021,6,5,3,3,1997)
            println("The input array is ${inputArray.joinToString(", ")}")
            mergeSort(inputArray)
            println("The result after the sorting is  ${inputArray.joinToString(", ")}")
        }

        fun mergeSort(inputArray: IntArray): IntArray {
            if (inputArray.size == 0) {
                return inputArray
            }
            mergeSort(inputArray, 0, inputArray.size - 1)
            return inputArray
        }

        fun mergeSort(inputArray: IntArray, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            // Define the middle
            val middle = (start + end) / 2
            mergeSort(inputArray, start, middle)
            mergeSort(inputArray, middle + 1, end)
            merge(inputArray, start, middle, end)
        }

        fun merge(inputArray: IntArray, start: Int, middle: Int, end: Int) {
            val result = IntArray(end - start + 1)
            var i = start
            var j = middle + 1
            var resultPost = 0
            while (i <= middle && j  <= end) {
                if (inputArray[i] <= inputArray[j]) {
                    result[resultPost++] = inputArray[i++]
                } else {
                    result[resultPost++] = inputArray[j++]
                }
            }

            // Flush reminder elements into the result
            while (i <= middle) {
                result[resultPost++] = inputArray[i++]
            }

            while (j <= end) {
                result[resultPost++] = inputArray[j++]
            }

            for (k in result.indices) {
                inputArray[start + k] = result[k]
            }

        }
    }
}