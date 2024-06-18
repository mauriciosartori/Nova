package com.android.nova.inverviewcamp.binarysearch.tricks
/**
 * Given an array that is cyclically sorted, find the minimum element.
 * A cyclically sorted array is a sorted array rotated by some number of elements.
 * Assume all elements are unique.
 * For example:A = [4,5,1,2,3], which is just [1,2,3,4,5] rotated by 2
 * Result = index2
 */
class BinarySearchTricks1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(4,5,6,1,2,3)
            println("The input array is ${inputArray.contentToString()}")
            val result = findSmallestMiniBu(inputArray)
            println("The result is the index $result and the value is ${inputArray[result]}")
        }

        fun findSmallestMiniBu(inputArray: IntArray): Int {
            var start = 0
            var end = inputArray.size - 1
            val lastValue = inputArray.last()

            while (start <= end) {
                val middle = (start +  end) / 2
                if (inputArray[middle] > lastValue) {
                    // We are in section 2
                    start = middle + 1
                } else {
                    // we are in section 1 check for conditions
                    // check if is the init index
                    if (middle == 0 && inputArray[lastValue] < inputArray[middle]) {
                        end = lastValue
                    }
                    if (middle == 0 && inputArray[lastValue] > inputArray[middle]) {
                        return middle
                    }
                    if (middle > 0 && inputArray[middle - 1] > inputArray[middle] ){
                        return middle
                    }
                    end = middle
                }
            }
            return  -1
        }
    }
}