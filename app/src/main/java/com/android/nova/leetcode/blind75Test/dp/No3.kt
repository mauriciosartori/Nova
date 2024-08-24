package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))
            println("The result for No2 is $result")
        }
        fun lengthOfLIS(nums: IntArray): Int {
            val dp = IntArray(nums.size) {1}
            var maxValue = 1
            for (i in 1..(nums.size - 1)) {

                for (j in 0..(i)) {
                    if(nums[i] > nums[j]) {
                        dp[i] = maxOf(dp[i], dp[j] + 1)
                    }
                }
                maxValue = maxOf(maxValue, dp[i])
            }
            return maxValue
        }
    }
}