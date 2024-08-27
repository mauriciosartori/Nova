package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No9 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = uniquePaths(3, 7)
            println("The result for the No9 is $result")
        }
        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m) {IntArray(n)}
            dp[0][0] = 1

            for (i in 0..< m) {
                for (j in 0..< n) {
                    if (i == 0 && j == 0) {
                        continue
                    }
                    // Check the vertical
                    if (i > 0 && i < m) {
                        dp[i][j] =  dp[i][j] + dp[i - 1][j]
                    }
                    // Check the horizontal
                    if (j > 0 && j < n) {
                        dp[i][j] =  dp[i][j] + dp[i][j - 1]
                    }
                }
            }
            return dp[m - 1][n - 1]
        }
    }
}