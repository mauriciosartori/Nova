package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No26 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Define the input array of coins and the target amount
            val coins = intArrayOf(1, 2, 5)
            val amount = 11
//            val coins = intArrayOf(2)
//            val amount = 3

            // Call the coinChange function and print the result
            val result = coinChange(coins, amount)
            println("Minimum coins needed: $result")
        }
        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1)
            coins.sort()

            for (i in 1 until dp.size) {
                val target = i
                var smallestSteps = Integer.MAX_VALUE
                for (coin in coins) {
                    val diff = target - coin
                    if (diff < 0) {
                        break
                    }
                    if (diff == 0) {
                        smallestSteps = 1
                        break
                    }
                    if (dp[diff] == Integer.MAX_VALUE) {
                        smallestSteps = Integer.MAX_VALUE
                        break
                    }
                    smallestSteps = minOf(smallestSteps,dp[diff] + 1)
                }
                dp[i] = smallestSteps
            }
            return if (dp[amount] < Integer.MAX_VALUE) dp[amount] else -1
        }
    }
}