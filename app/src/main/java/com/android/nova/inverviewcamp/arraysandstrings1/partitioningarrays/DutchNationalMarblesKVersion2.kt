package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 * Given an array with n marbles colored Red, White or Blue,
 * sort them so that marbles of the same color are adjacent,
 * with the colors in the order Red, White and Blue.
 * Assume the colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
 * For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
 */
class DutchNationalMarblesKVersion2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 0, 1, 2, 1, 0, 1, 2)
            val middleColor = 2
            println("The input array is ${inputArray.contentToString()}")
            println("Question here, can you do a different arrangement?")
            sortColors(inputArray, middleColor)
            println("The result of this thingy is ${inputArray.contentToString()}")
        }

        fun sortColors(inputArray: IntArray, middleColor: Int) {
            var  lowBoundary = 0
            var  highBoundary = inputArray.size - 1
            var  index = 0

            while (index <= highBoundary) {
                when {
                     inputArray[index]  == 0 -> {
                        swap(inputArray, index, lowBoundary)
                        lowBoundary++
                        index++
                    }
                    inputArray[index]  == 1 -> {
                        swap(inputArray, index, highBoundary)
                        highBoundary--
                    }
                    else -> {
                        index++
                    }
                }
            }
        }

        fun swap(inputArray: IntArray, a:Int, b:Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}