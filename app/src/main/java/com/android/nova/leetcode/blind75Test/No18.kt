package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No18 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = missingNumber(intArrayOf(0,1))
            val result = missingNumber(intArrayOf(3,0,1))
            println("The solution is $result")
        }

        fun missingNumber(nums: IntArray): Int {
            var currentResult = 0
            for (i in nums.indices) {
                currentResult = nums[i] xor i xor currentResult
            }

            currentResult = currentResult xor nums.size

            return currentResult
        }
    }
}