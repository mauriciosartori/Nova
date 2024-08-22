package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No9 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = twoSum(intArrayOf(2,7,11,15), 9)
            println("The result is ${result.contentToString()}")
        }
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var start = 0
            var end = numbers.size - 1
            while (start <= end) {
                val currentSum = numbers[start] + numbers[end]

                if (currentSum > target) {
                    end--
                } else if (currentSum < target) {
                    start++
                } else {
                    break
                }
            }
            return intArrayOf(start + 1, end + 1)
        }
    }
}