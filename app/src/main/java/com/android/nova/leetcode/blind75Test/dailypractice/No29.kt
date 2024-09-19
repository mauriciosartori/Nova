package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No29 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "au"
            val result = lengthOfLongestSubstring(s)
            println("Length of Longest Substring Without Repeating Characters: $result")
        }
        fun lengthOfLongestSubstring(s: String): Int {
            if (s.equals("")) {
                return 0
            }
            val inputSize = s.length
            var maxSize = 1
            for (i in 0 until inputSize) {
                var wordLength = 1
                var maxLength = 1
                var set = HashSet<Char>()
                set.add(s[i])
                for (j in i + 1 until inputSize) {
                    if (set.contains(s[j])) {
                        break
                    }
                    wordLength++
                    maxLength = maxOf(maxLength, wordLength)
                    set.add(s[j])
                }
                maxSize = maxOf(maxSize, maxLength)
            }
            return maxSize
        }
    }
}