package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No14 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val N = 6L
            val F = 3
            val P = arrayOf(5L, 2L, 4L)
            val result = getSecondsRequired(N, F, P)
            println("Result: $result")  // Expected output after running the function
        }

        fun getSecondsRequired(N: Long, F: Int, P: Array<Long>): Long {
            var minP = P[0];
            for (i in 1 until F) {
                minP = minOf(minP, P[i]);
            }
            return N - minP;
        }
    }
}