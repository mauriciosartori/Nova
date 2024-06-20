package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 *
 */
class PrintAllPermutations {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,4,5,6,7)
            println("Input array ${inputArray.contentToString()}")
            printPermutations(inputArray, IntArray(3), 0, BooleanArray(inputArray.size))
        }
        fun printPermutations(inputArray:IntArray, bufferArray:IntArray, bufferIndex:Int, isInBufferArray:BooleanArray) {
            if (bufferIndex == bufferArray.size) {
                println(bufferArray.contentToString())
                return
            }

            for (i in 0 until inputArray.size) {
                if (!isInBufferArray[i]) {
                    bufferArray[bufferIndex] = inputArray[i]
                    isInBufferArray[i] = true
                    printPermutations(inputArray, bufferArray, bufferIndex + 1, isInBufferArray)
                    isInBufferArray[i] = false
                }

            }
        }
    }
}