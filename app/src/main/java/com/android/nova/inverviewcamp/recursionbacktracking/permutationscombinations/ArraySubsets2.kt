package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Question Discussed: (Level: Medium) Print all SUBSETS of an array of integers
 */
class ArraySubsets2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3)
            println("Poker input array is ${inputArray.contentToString()}")
            printSubsets(inputArray, IntArray(3), 0, 0)
        }

        fun printSubsets(inputArray: IntArray, bufferArray: IntArray, startIndex: Int, bufIndex: Int ) {
            // Work on base cases
            if (bufIndex == bufferArray.size) {
                return
            }


            for (i in startIndex.. inputArray.size - 1) {
                bufferArray[bufIndex] = inputArray[i]
                cleanSpacesAhead(bufferArray, bufIndex)
                println(bufferArray.contentToString())
                printSubsets(inputArray, bufferArray, i + 1, bufIndex + 1 )
            }
        }

        fun cleanSpacesAhead(bufferArray: IntArray, lastIndex: Int) {
            for (i in lastIndex + 1 ..< bufferArray.size) {
                bufferArray[i] = 0
            }
        }
    }
}