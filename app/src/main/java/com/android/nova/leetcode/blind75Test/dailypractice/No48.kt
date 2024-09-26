package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No48 {
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

            fun getMostRepeatedCharCount(): Int {
                var count = 0
                for ((char, num) in memo) {
                    count = maxOf(count, num)
                }
                return count
            }

            var left = 0
            var right = 0
            var result = 0
            while (right < input.length) {
                memo[input[right]] = memo.getOrDefault(input[right], 0) + 1
                val mostRepeated = getMostRepeatedCharCount()
                while ((right - left + 1) - mostRepeated > k ) {
                    memo[input[left]] = memo.getOrDefault(input[left], 1) - 1
                    left++
                }
                result = maxOf(result, right - left + 1)
                right++
            }
            return result
        }
    }
}