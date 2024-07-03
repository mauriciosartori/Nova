package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all subsets of an array of integers
 */
class ArraySubsets1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3)
            println("The input array is ${inputArray.contentToString()}")
            printSubsets(inputArray, IntArray(inputArray.size), 0, 0)
        }

        fun printSubsets(inputArray: IntArray, buffer: IntArray, startIndex: Int, bufferIndex: Int) {

            println(buffer.contentToString())

            // Define base case
            if (bufferIndex == buffer.size) {
                buffer[0] = 0
                buffer[1] = 0
                buffer[2] = 0
                return
            }

            for (i in startIndex..inputArray.size - 1) {
                buffer[bufferIndex] = inputArray[i]
                printSubsets(inputArray, buffer, i + 1, bufferIndex + 1)
            }
        }
    }
}