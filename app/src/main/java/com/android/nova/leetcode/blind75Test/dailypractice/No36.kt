package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No36 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun getMinCodeEntryTime(N: Int, M: Int, C: Array<Int>): Long {
            val memo = HashMap<Int, Int>()
            for (i in 0 until N) {
                memo[i] = N + i
            }

            val combination = C
            var prev = 1
            var totalRotations = 0
            for (num in combination) {
                val left = if (prev - num < 0) num - prev else prev - num
                val right = if (memo[prev]!! - num < 0) num - memo[prev]!! else memo[prev]!! - num
                val rotation = minOf(left, right)
                totalRotations += rotation
            }
            return totalRotations.toLong()

        }
    }
}