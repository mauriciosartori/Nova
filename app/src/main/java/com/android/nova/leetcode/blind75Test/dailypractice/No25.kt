package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No25 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Define the input array of coins and the target amount
            val coins = intArrayOf(1, 2, 5)
            val amount = 100

            // Call the coinChange function and print the result
            val result = coinChange(coins, amount)
            println("Minimum coins needed: $result")
        }
        fun coinChange(coins: IntArray, amount: Int): Int {
            if (amount == 0) {
                return 0
            }

            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(Pair(0,0))
            var totalSteps = Integer.MAX_VALUE

            while (!queue.isEmpty()) {
                val coinPair = queue.removeFirst()
                val steps = coinPair.first
                val sum  = coinPair.second
                if (sum > amount) {
                    continue
                }
                if (sum == amount) {
                    totalSteps = minOf(totalSteps, steps)
                }

                for (item in coins) {
                    queue.add(Pair(steps + 1, sum + item))
                }
            }

            return if (totalSteps == Integer.MAX_VALUE) -1 else totalSteps
        }
    }
}