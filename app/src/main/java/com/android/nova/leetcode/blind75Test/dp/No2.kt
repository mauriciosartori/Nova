package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))
            println("The result for No2 is $result")
        }
        fun lengthOfLIS(nums: IntArray): Int {
            val dp = IntArray(nums.size) {1}

            var maxValue = 0
            for (i in nums.indices) {
                var currentHighestValue = 1
                for (j in 0..(i-1)) {
                    if(nums[i] > nums[j]) {
                        currentHighestValue = dp[j] + 1
                    }
                }
                dp[i] = currentHighestValue
                maxValue = maxOf(maxValue, dp[i])
            }
            return maxValue
        }
    }
}