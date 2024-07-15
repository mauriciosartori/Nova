package com.android.nova.inverviewcamp.arraysandstrings2.tricks
/**
 * Homework Problem 1 (Level: Easy)
 * Rotate an array A by X items. For example,
 * A = [1,2,3,4,5,6] and X = 2, Result = [5,6,1,2,3,4]
 *
 * Hint: Use same trick we used in "Reverse Words of a Sentence" above.
 *
 */
class RotateArrayByXElements {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,4,5,6)
            val x = 3
            println("Rotating the following array  ${inputArray.contentToString()}")
            rotateArray(inputArray, x)
        }

        fun rotateArray(inputArray: IntArray, positionsToRotate: Int) {
            var start = 0
            var end = inputArray.size - 1

            while (start <= end) {
                swap(inputArray, start, end)
                start++
                end--
            }
            rotateByPosition(inputArray, 0, positionsToRotate - 1)
            println("The rotated array so far looks like this ${inputArray.contentToString()}")

            rotateByPosition(inputArray,  positionsToRotate, inputArray.size - 1)
            println("Then the rest of the roated arred would look like this ${inputArray.contentToString()}")
        }

        fun rotateByPosition(inputArray: IntArray, startIndex: Int, endIndex:Int) {
            var start = startIndex
            var end = endIndex
            for (i in start..end - 1) {
                swap(inputArray, start, end)
                start++
                end--
            }
        }

        fun swap(inputArray: IntArray, start: Int, end: Int) {
            val temp = inputArray[start]
            inputArray[start] = inputArray[end]
            inputArray[end] = temp
        }
    }
}