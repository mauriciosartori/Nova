package com.android.nova.inverviewcamp.binarysearch.tricks
/**
 * A peak element in an array A is an A[i] where its neighboring elements are less than A[i].
 * So, A[i - 1] < A[i] and A[i + 1] < A[i].
 * Assume there are no duplicates. Also, assume that A[-1] and A[length] are negative infinity (-∞).
 * So A[0] can be a peak if A[1] < A[0].
 *
 * A = [1,3,4,5,2] => Peak = 5
 * A = [5,3,1] => Peak = 5
 * A = [1,3,5] => Peak = 5
 */
class BinarySearchTricks3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(7,6,5,1,2,3,4,0)
            println("The input array is ${inputArray.contentToString()}")
            val result = findPeak(inputArray)
            println("The peak is index $result and the number is ${inputArray[result]}")
        }
        fun findPeak(inputArray: IntArray) : Int {
            var start = 0
            var end = inputArray.size - 1

            while (start <= end) {
                val middle = (start + end) / 2
                val left = if (middle > 0) middle - 1 else 0
                val right = if (middle == inputArray.size -1) inputArray.size -1 else middle + 1

                if (inputArray[left] < inputArray[middle] && inputArray[middle] < inputArray[right]) {
                    start = right
                } else if (inputArray[left] > inputArray[middle] && inputArray[middle] > inputArray[right]) {
                    end = left
                } else if (inputArray[left] > inputArray[middle] && inputArray[middle] < inputArray[right]) {
                    start = right
                }
                else {
                    return middle
                }
            }
            return -1
        }
    }
}