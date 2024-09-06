package com.android.nova.leetcode.blind75Test.string
/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = lengthOfLongestSubstring("abcabcbb")
            val result = lengthOfLongestSubstring("dvdf")

            println("The result of No 1 $result ")
        }

        fun lengthOfLongestSubstring(s: String): Int {
            var left = 0
            var right = 0
            var set = HashSet<Char>()
            var result = 0

            while (left <= right && right < s.length) {
                if (set.contains(s[right])) {
                    left++
                    set.remove(s[right])
                } else {
                    set.add(s[right])
                    result = maxOf(result, right - left + 1)
                }
                right++
            }
            return result
        }
    }
}