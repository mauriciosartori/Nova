package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 * Question 1 (discussed in video): You are given an array of integers.
 * Rearrange the array so that all zeroes are at the beginning of the array.
 * For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
 */
class PartitioningArrayKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(4,2,0,1,0,3,0)
            println("Partitioning Arrays")
            sortArray(inputArray)
        }

        fun sortArray(inputArray: IntArray) {
            var boundaryIndex = 0
            for (i in inputArray.indices) {
                if (inputArray[i] == 0) {
                    swap(inputArray, i, boundaryIndex)
                    boundaryIndex++
                }
            }
            println("The result array is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, a: Int, b:Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }

}