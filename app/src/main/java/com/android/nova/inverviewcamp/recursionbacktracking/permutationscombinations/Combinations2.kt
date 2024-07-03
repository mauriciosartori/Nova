package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all combinations of length 3
 */
class Combinations2 {
    companion object {
        val groupLength = 3
        @JvmStatic
        fun main(args: Array<String>) {

            val inputArray = intArrayOf(1,2,3,4,5,6,7)
            println("The input array is ${inputArray.contentToString()}")
            printCombos(inputArray, IntArray(3), 0, 0)
        }

        fun printCombos(inputArray: IntArray, buffer: IntArray, startIndex:Int, bufferIndex:Int) {
            if (buffer.size  == bufferIndex) {
                println(buffer.contentToString())
                return
            }
            if (startIndex == inputArray.size) {
                return
            }

            for (i in startIndex.. inputArray.size - 1) {
                buffer[bufferIndex] = inputArray[i]
                printCombos(inputArray, buffer, i + 1, bufferIndex + 1)
            }
        }
    }
}