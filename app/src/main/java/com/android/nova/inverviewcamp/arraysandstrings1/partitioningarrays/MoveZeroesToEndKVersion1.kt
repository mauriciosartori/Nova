package com.android.nova.inverviewcamp.arraysandstrings1.partitioningarrays

/**
 *  Given an array, move all zeroes to the end of the array.
 * For example, [4,2,0,1,0,3,0] -> [4,1,2,3,0,0,0]
 */
class MoveZeroesToEndKVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(4,2,0,1,0,3,0)
            println("The input array is ${inputArray.contentToString()}")
            moveZeroesToTheEnd(inputArray)
        }

        fun moveZeroesToTheEnd(inputArray: IntArray) {
            var start = 0
            var end = inputArray.size - 1

            while (start <= end) {
                if (inputArray[start] == 0) {
                    swap(inputArray, start, end)
                    end--
                } else {
                    start++
                }
            }

            println("The final array is ${inputArray.contentToString()}")
        }

        fun swap(inputArray: IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}