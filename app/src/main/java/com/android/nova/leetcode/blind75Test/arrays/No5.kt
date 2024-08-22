package com.android.nova.leetcode.blind75Test.arrays

/**
 *
 */
class No5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
            println(result)
        }
        fun maxSubArray(nums: IntArray): Int {
            // Ask yourself who is higher the current nums[i] or the sum
            var currentSum = 0
            var maxSum = Int.MIN_VALUE
            for (i in nums.indices) {
                currentSum = Math.max(nums[i], currentSum + nums[i])
                if (currentSum > maxSum) {
                    maxSum = currentSum
                }
            }
            return maxSum
        }
    }
}