package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all combinations of length 3
 */
class Combinations {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val length = 3
            //val inputArray = intArrayOf(1,2,3,4,5,6,7)
            val inputArray = intArrayOf(1,2,3)
            println("The input array is ${inputArray.contentToString()}")
            printCombos(inputArray, IntArray(3), 0, 0)
        }

        fun printCombos(inputArray: IntArray, buffer: IntArray, startIndex:Int, bufferIndex:Int) {
            // check the base cases
            if (bufferIndex == buffer.size) {
                println(buffer.contentToString())
                return
            }
            if (startIndex == inputArray.size) {
                return
            }
            // Find candidates that go into the current buffer index
            for (i in startIndex..< inputArray.size) {
                buffer[bufferIndex] = inputArray[i]
                printCombos(inputArray, buffer, i + 1, bufferIndex + 1)
            }
        }
    }
}