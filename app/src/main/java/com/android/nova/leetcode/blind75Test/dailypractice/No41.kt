package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No41 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "AABABBA"
            val k = 1
            println(characterReplacement(s, k))
        }
        fun characterReplacement(s: String, k: Int): Int {
            val input = s
            val memo = HashMap<Char, Int>()

            fun getLongestSize(): Int {
                var count = 0
                for ((item, itemCount) in memo) {
                    count = maxOf(count, itemCount)
                }
                return count
            }

            var start = 0
            var end = 0
            var sports = k
            var maxSubstring = 0
            while (start <= end && end < input.length) {

                val size = getLongestSize()
                val subSize = end - start
                val available = (subSize - size)
                if ( available <= sports) {
                    val current = input[end]
                    memo[current] = memo.getOrDefault(current, 0) + 1
                    end++
                    maxSubstring = maxOf(maxSubstring, end - start)
                } else {
                    val startChar = input[start]
                    memo[startChar] = memo.getOrDefault(startChar, 0) - 1
                    start++
                }

            }
            return maxSubstring
        }
    }
}