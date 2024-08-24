package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = rob(intArrayOf(0,0))
            println("The result of No6 is $result")
        }

        fun rob(nums: IntArray): Int {
            if (nums.size == 0) {
                return 0
            }
            if (nums.size == 1) {
                return nums[0]
            }
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            dp[1] = maxOf(nums[0], nums[1])
            var maxValue = maxOf(nums[0], nums[1])
            for (i in 2..(nums.size - 1)) {
                val currentValue = maxOf(nums[i] + dp[i - 2], dp[i - 1])
                dp[i] = currentValue
                maxValue = maxOf(currentValue, maxValue)
            }
            return maxValue
        }
    }
}