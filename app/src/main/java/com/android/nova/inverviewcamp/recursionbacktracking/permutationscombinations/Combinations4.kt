package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all combinations of length 3
 */
class Combinations4 {
    companion object {
        val groupLength = 3

        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            println("Chasing optimal scenario so, the input array is ${inputArray.contentToString()}")
            printCombinations(inputArray, IntArray(3),0, 0)
        }

        fun printCombinations(inputArray: IntArray, buffer: IntArray, start: Int, bufferIndex: Int) {
            if (bufferIndex == buffer.size) {
                println(buffer.contentToString())
                return
            }
            for (i in start..<inputArray.size ) {
             buffer[bufferIndex] = inputArray[i]
             printCombinations(inputArray, buffer, i + 1, bufferIndex + 1)
            }
        }
    }

}