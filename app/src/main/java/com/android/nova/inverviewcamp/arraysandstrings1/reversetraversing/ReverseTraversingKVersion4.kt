package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/** Interview CampLevel:Easy
 * Given an array of numbers, replace each EVEN number with two of the same number.
 * e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
class ReverseTraversingKVersion4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 5, 6, 8, -1, -1, -1)
            println("V4 Array input ${inputArray.contentToString()}")
            addingEvenDoubles(inputArray)
            println("The result of this madre is ${inputArray.contentToString()}")
        }

        fun addingEvenDoubles(inputArray: IntArray) {
            var mainIndex = inputArray.size - 1
            var endIndex = findEndPosition(inputArray)

            for (i in endIndex downTo 0) {
                if (inputArray[endIndex] % 2 == 0) {
                    inputArray[mainIndex--] = inputArray[endIndex]
                }
                inputArray[mainIndex--] = inputArray[endIndex--]
            }
        }

        fun findEndPosition(inputArray: IntArray): Int {
            var j = 0
            for (i in inputArray) {
                if (i == -1) {
                    return j - 1
                }
                j++
            }
            return j
        }
    }
}