package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 *
 */
class PrintAllPermutations1 {
    companion object {
        const val permutationSize = 3
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,4,5,6,7)
            println("Permutation practice")
            println("Input array ${inputArray.contentToString()}")
            printPermutations(inputArray, IntArray(permutationSize), 0, 0)
        }
        fun printPermutations(inputArray: IntArray, bufferArray: IntArray, startIndex:Int, bufferIndex:Int) {
            if (bufferArray.size == bufferIndex) {
                println(bufferArray.contentToString())
                return
            }

            for (i in 0..inputArray.size - 1) {
                bufferArray[bufferIndex] = inputArray[i]
                printPermutations(inputArray, bufferArray, i + 1, bufferIndex + 1)
            }
        }
    }
}