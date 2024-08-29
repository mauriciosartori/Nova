package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class no9 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intArray = intArrayOf(-6, -1, -1, 9, -8, -6, -6, 4, 4, -3, -8, -1)
            val result = longestConsecutive(intArray)
            println("The result for the No9 is $result")
        }

        fun longestConsecutive(nums: IntArray): Int {
            val setNums = nums.toSet()
            if (setNums.size == 1) {
                return 1
            }
            if (setNums.size == 0) {
                return 0
            }

            var maxSize = 1
            for(num  in setNums) {
                // Check if is a start
                if (!setNums.contains(num - 1)) {
                    var i = 1
                    // It is the start, then start counting how many numbers are to the right
                    while (setNums.contains(num + i)) {
                        i++
                        maxSize = maxOf(maxSize, i)
                    }
                }
            }
            return maxSize
        }
    }
}