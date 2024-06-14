package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/** Interview CampLevel:Easy
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].Assume that the array has the exact amount of space
 * to accommodate the result.
 **/
class ReverseTraversingKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //var inputArray = {1,2,5,6,8, , , ,}
            val inputArray = intArrayOf(1,2,5,6,8, -1,-1 ,-1)
            println("Array input ${inputArray.contentToString()}")
            sortingDoubles(inputArray)
        }

        fun sortingDoubles(inputArray: IntArray) {
            if (inputArray.isEmpty()){
                println("The array is empty")
                return
            }
            var lastIndex = getLastIndex(inputArray)
            var lastAvailableSpace = inputArray.size - 1

            while(lastIndex >= 0) {
                if (inputArray[lastIndex] % 2 == 0) {
                    inputArray[lastAvailableSpace--] = inputArray[lastIndex]
                }
                inputArray[lastAvailableSpace--] = inputArray[lastIndex]
                lastIndex--
            }
            println("The result array is ${inputArray.contentToString()}")
        }
        fun getLastIndex(inputArray: IntArray):Int {
            var lastIndex = inputArray.size - 1
            while (lastIndex >= 0) {
                if (inputArray[lastIndex] != -1) {
                    return lastIndex
                }
                lastIndex--
            }
            return lastIndex
        }
    }
}