package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all combinations of length 3
 */
class Combinations3 {
    companion object {
        val groupLength = 3

        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            println("Chasing optimal scenario so, the input array is ${inputArray.contentToString()}")
            printCombos(inputArray, IntArray(groupLength), 0, 0)
        }
        fun printCombos(inputArray: IntArray, buffer: IntArray, startIndex: Int, buffIndex: Int) {
            if (buffIndex == buffer.size) {
                println(buffer.contentToString())
                return
            }

            for (i in startIndex..< inputArray.size) {
                buffer[buffIndex] = inputArray[i]
                printCombos(inputArray, buffer, i + 1, buffIndex + 1)
            }
        }
    }
}