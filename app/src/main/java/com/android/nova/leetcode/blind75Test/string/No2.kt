package com.android.nova.leetcode.blind75Test.string
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = lengthOfLongestSubstring("abcabcbb")
            val result = lengthOfLongestSubstring("dvdf")

            println("The result of No 1 $result ")
        }

        fun lengthOfLongestSubstring(s: String): Int {
            val set = HashSet<Char>()
            var right = 0
            var left = 0
            var count = 0
            var result = 0

            for (right in 0 until s.length) {
                while(set.contains(s[right])) {
                    set.remove(s[left])
                    left++
                }
                count = right - left + 1
                result = maxOf(result, count)
                set.add(s[right])
            }
            return result
        }
    }
}