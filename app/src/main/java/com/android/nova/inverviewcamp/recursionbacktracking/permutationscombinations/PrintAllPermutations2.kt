package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 *
 */
class PrintAllPermutations2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,4,5,6,7)
            println("Input array ${inputArray.contentToString()}")
            printPermutations(inputArray, IntArray(3), 0)
        }

        fun printPermutations(inputArray: IntArray, buffer: IntArray, buffIndex: Int) {
            if (buffIndex == buffer.size) {
                println(buffer.contentToString())
                return
            }

            for (i in 0..< inputArray.size) {
                if (!numberInUse(buffer, buffIndex, inputArray[i])) {
                    buffer[buffIndex] = inputArray[i]
                    printPermutations(inputArray, buffer, buffIndex + 1)
                }
            }
        }

        fun numberInUse(buffer: IntArray, buffIndex: Int, candidate: Int):Boolean {
            if (buffIndex == 0) {
                return false
            }
            for (i in (buffIndex - 1)downTo 0) {
                if (buffer[i] == candidate) {
                    return true
                }
            }
            return false
        }
    }
}