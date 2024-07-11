package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/** Interview CampLevel:Easy
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
class ReverseTraversingKVersion3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 5, 6, 8, -1, -1, -1)
            println("Plastilina V3 Array input ${inputArray.contentToString()}")
            addingEvenDoubles(inputArray)
        }

        fun addingEvenDoubles(inputArray:IntArray) {
            var end = findEndOfArray(inputArray)


            var availableSpot = inputArray.size - 1

            while (end >= 0) {
                if (inputArray[end] % 2 == 0) {
                    inputArray[availableSpot--] = inputArray[end]
                }
                inputArray[availableSpot--] = inputArray[end--]
            }
            println("The result of this is ${inputArray.contentToString()}")
        }

        fun findEndOfArray(inputArray: IntArray): Int{
            var endIndex = 0
            for (i in inputArray.indices) {
                if (inputArray[i] == -1) {
                    return i - 1
                }
                endIndex++
            }
            return 0
        }
    }
}