package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class TemplateClassKVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1)
            val coinsSorted = coins.sorted()

            for (i in 1..amount) {
                var min = Int.MAX_VALUE

                for (coin in coinsSorted) {
                    val sum = i - coin
                    if (sum < 0) {
                        break
                    }
                    min = minOf(min, dp[sum] + 1)
                }
                dp[i] = min
            }
            if (dp[amount] != Int.MAX_VALUE) {
                return dp[amount]
            }
            return -1
        }
    }
}