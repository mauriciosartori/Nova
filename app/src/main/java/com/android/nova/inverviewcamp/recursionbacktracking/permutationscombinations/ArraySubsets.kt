package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all subsets of an array of integers
 */
class ArraySubsets {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3)
            println("The input array is ${inputArray.contentToString()}")
            printSubsets(inputArray, IntArray(inputArray.size), 0, 0)
        }

        fun printSubsets(inputArray: IntArray, bufferArray: IntArray, startIndex: Int, bufferIndex: Int) {

            println(bufferArray.contentToString())
            // Define base case
            if (bufferIndex == bufferArray.size) {
                bufferArray[0] = 0
                bufferArray[1] = 0
                bufferArray[2] = 0
                return
            }
            if (startIndex == inputArray.size) {
                bufferArray[0] = 0
                bufferArray[1] = 0
                bufferArray[2] = 0
                return
            }

            for (i in startIndex until inputArray.size) {
                bufferArray[bufferIndex] = inputArray[i]
                printSubsets(inputArray, bufferArray, i + 1, bufferIndex + 1)
            }

        }
    }
}