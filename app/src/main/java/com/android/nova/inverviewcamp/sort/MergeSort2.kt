package com.android.nova.inverviewcamp.sort
/**
 * Implement a classic merge sort
 */
class MergeSort2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,9,7,4,2021,6,5,3,3,1997, 19, 17, 21)
            println("Sixtete: The input array is ${inputArray.joinToString(", ")}")
            mergeSort(inputArray)
            println("The result after the sorting is  ${inputArray.joinToString(", ")}")
        }

        fun mergeSort(inputArray: IntArray) {
            sort(inputArray, 0, inputArray.size - 1)
        }

        fun sort(inputArray: IntArray, start: Int, end: Int) {
            if (start >= end) {
                return
            }
            val mid = (start + end) / 2
            sort(inputArray, start, mid)
            sort(inputArray, mid + 1, end)
            merge(inputArray, start, mid, end)
        }

        fun merge(inputArray: IntArray, start: Int, mid: Int, end: Int) {
            val result = IntArray(end - start + 1)
            var i = start
            var j = mid + 1
            var resultPost = 0
            while ( i <= mid && j <= end) {
                if (inputArray[i] <= inputArray[j]) {
                    result[resultPost++] = inputArray[i++]
                } else  {
                    result[resultPost++] = inputArray[j++]
                }
            }

            // Do the flush for i and then for j

            while (i <= mid) {
                result[resultPost++] = inputArray[i++]
            }

            while (j <= end) {
                result[resultPost++] = inputArray[j++]
            }

            // Copy the result array into my prv array
            for (k in result.indices) {
                inputArray[k + start] = result[k]
            }
        }
    }
}