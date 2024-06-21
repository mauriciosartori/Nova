package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/** Interview CampLevel:Easy
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8, , , ] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
class ReverseTraversingKVersion2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,5,6,8, -1,-1 ,-1)
            println("Array input ${inputArray.contentToString()}")
            sortingDoubles(inputArray)
        }

        fun sortingDoubles(inputArray: IntArray) {
            val endIndex = getEndIndex(inputArray)
            var currentIndex = inputArray.size - 1

            for (i in endIndex downTo 0 ) {
                 if (inputArray[i] % 2 == 0) {
                     inputArray[currentIndex] = inputArray[i]
                     currentIndex--
                 }
                inputArray[currentIndex] = inputArray[i]
                currentIndex--
            }

            println("The array result would be ${inputArray.contentToString()}")
        }

        fun getEndIndex(inputArray: IntArray): Int {
            for (i in inputArray.size - 1 downTo 0) {
                if (inputArray[i] != -1) {
                    return i
                }
            }
            return 0
        }
    }
}