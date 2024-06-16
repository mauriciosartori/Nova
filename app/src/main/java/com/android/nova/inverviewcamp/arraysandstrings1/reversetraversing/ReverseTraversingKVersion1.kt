package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/** Interview CampLevel:Easy
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
class ReverseTraversingKVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1, 2, 5, 6, 8, -1, -1, -1)
            println("Array input ${inputArray.contentToString()}")
            addingEvenDoubles(inputArray)
        }

        fun addingEvenDoubles(inputArray: IntArray) {
            var lastIndex = findLastNumberIndex(inputArray)

            var i = inputArray.size - 1
            while(i >= 0) {
                inputArray[i] = inputArray[lastIndex]
                i--
                // Check if it is an even number
                if(lastIndex >= 0 && inputArray[lastIndex] % 2 == 0) {
                    inputArray[i] = inputArray[lastIndex]
                    i--
                }
                lastIndex--
            }

            println("Teh result for this array is ${inputArray.contentToString()}")
        }

        fun findLastNumberIndex(inputArray: IntArray):Int {
            for (i in inputArray.size - 1 downTo 0) {
                if(inputArray[i] != -1) {
                    return i
                }
            }
            return 0
        }
    }
}