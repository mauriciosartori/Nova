package com.android.nova.inverviewcamp.arraysandstrings2.twodarrays
/**
 * 1. (Level: Medium) Rotate a 2D array clockwise by 90 degrees,
 * like rotating the pixels of an image
 */
class TwoDArrays {
    companion object {
        val inputArray: Array<IntArray> = arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12),
            intArrayOf(13,14,15,16)
        )
        @JvmStatic
        fun main(args: Array<String>) {
            println("The input array is ")
            printArray()
            println(" ")
            println("After the rotation the result is")
            rotateArray()
            printArray()
        }

        fun rotateArray() {
            var left = 0
            var right = inputArray.size - 1
            while (left < right) {
                for (i in left.. (right - 1)) {
                    var top = left
                    var bottom = right
                    val topLeft = inputArray[top][left + i]
                    inputArray[top][left + i] = inputArray[bottom - i ][left]
                    inputArray[bottom - i][left] = inputArray[bottom][right - i]
                    inputArray[bottom][right - i] = inputArray[top + i][right]
                    inputArray[top + i][right] = topLeft
                }
                left = left + 1
                right = right - 1
            }
        }

        fun printArray() {
            for (i in inputArray.indices) {
                for (j in inputArray[0].indices) {
                    print("${inputArray[i][j]} ")
                }
                println(" ")
            }
        }
    }
}