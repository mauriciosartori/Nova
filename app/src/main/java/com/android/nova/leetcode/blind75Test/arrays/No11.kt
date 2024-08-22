package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No11 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = threeSum(intArrayOf(-1,0,1,2,-1,-4))
            println("Result ${result.joinToString(", ")}")
        }
        fun threeSum(nums: IntArray): List<List<Int>> {
            // Sort the array
            val numsSorted = nums.sortedArray()
            val result = ArrayList<List<Int>>()

            for (i in numsSorted.indices) {

                var start = i + 1
                var end = numsSorted.size - 1
                val currentSum = numsSorted[i]

                while (start < end) {
                    var currentResult = numsSorted[start] + numsSorted[end] + currentSum
                    if (currentResult == 0) {
                        val listItemResult = listOf(numsSorted[i],numsSorted[start], numsSorted[end])
                        result.add(listItemResult)
                        break
                    } else if (currentSum < currentSum) {
                        end++
                    } else {
                        start++
                    }
                }
            }
            return result
        }
    }
}