package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 * Question 1 (discussed in video): You are given an array of integers.
 * Rearrange the array so that all zeroes are at the beginning of the array.
 * For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
 */
class PartitioningArrayKVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(4,2,0,1,0,3,0)
            println("Partitioning Arrays the input is ${inputArray.contentToString()}")
            sortArray(inputArray)
        }

        fun sortArray(inputArray: IntArray) {
            var start = 0
            var iterations = 0
            var end = inputArray.size - 1

            while (start <= end) {
                if (inputArray[end] == 0) {
                    swap(inputArray, start, end)
                    start++
                } else {
                    end--
                }
                iterations++
            }

            println("The final result is ${inputArray.contentToString()} and we did $iterations iterations")
        }

        fun swap(inputArray: IntArray, firstIndex: Int, secondIndex: Int) {
            val temp = inputArray[firstIndex]
            inputArray[firstIndex] = inputArray[secondIndex]
            inputArray[secondIndex] = temp
        }
    }

}