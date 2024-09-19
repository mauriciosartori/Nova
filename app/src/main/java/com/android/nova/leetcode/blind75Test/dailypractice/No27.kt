package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No27 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
            val result = lengthOfLIS(nums)
            val memo = Array<IntArray>(2) { intArrayOf(1) }
            println("Length of Longest Increasing Subsequence: $result")
        }
        fun lengthOfLIS(nums: IntArray): Int {
            val dp = IntArray(nums.size)
            var maxSequence = 0

            for ((i, currentValue) in nums.withIndex()) {
                var longuestSub = 1
                for (j in i - 1 downTo 0) {
                    if (nums[j] < currentValue && dp[j] + 1 > longuestSub) {
                        longuestSub = maxOf(longuestSub, dp[j] + 1)
                    }
                }
                dp[i] = longuestSub
                maxSequence = maxOf(maxSequence, longuestSub)
            }
            return maxSequence
        }
    }
}