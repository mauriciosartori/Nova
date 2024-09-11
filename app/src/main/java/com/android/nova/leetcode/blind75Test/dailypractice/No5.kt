package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = uniquePaths(3, 7)
            println("The result of No5 is $result")
        }
        fun uniquePaths(m: Int, n: Int): Int {
            val memo = Array(m){ IntArray(n) }

            findPaths(0, 0, memo)
            return memo[m - 1] [n - 1]
        }

        fun findPaths(row:Int, col: Int, memo: Array<IntArray>) {
            if (row < 0 || col < 0 || row >= memo.size || col >= memo[0].size) {
                return
            }
            memo[row][col] = memo[row][col] + 1
            findPaths(row, col + 1, memo)
            findPaths(row + 1, col, memo)
        }
    }
}