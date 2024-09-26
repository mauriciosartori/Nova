package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No47 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val s = "ABAB"
//            val k = 2
            val s = "AABABBA"
            val k = 1
            println(characterReplacement(s, k))
        }
        fun characterReplacement(s: String, k: Int): Int {
            val input = s
            val memo = HashMap<Char, Int>()
            var i = 1
            var maxLength = 1
            for (char in input) {
                var valor = memo.getOrDefault(char, 1)
                if (i - valor <= k) {
                    maxLength = maxOf(maxLength, valor + k)
                }
                memo[char] = memo.getOrDefault(char, 1) + 1
                i++
            }
            return maxLength
        }
    }
}