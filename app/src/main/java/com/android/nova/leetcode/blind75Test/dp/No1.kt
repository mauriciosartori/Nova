package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = coinChange(intArrayOf(2), 3)
            println("The result is $result")

        }
        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1)
            val coinsSorted = coins.sorted()

            for (i in 1..amount) {
                var min = Int.MAX_VALUE
                if (i== 3){
                    println("Now do nothing")
                }
                for (coin in coinsSorted) {
                    val sum = i - coin
                    if (sum < 0) {
                        break
                    }
                    if (dp[sum] == Int.MAX_VALUE) {
                        min = minOf(min, Int.MAX_VALUE)
                    } else {
                        min = minOf(min, dp[sum] + 1)
                    }
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