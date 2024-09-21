package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No40 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val haystack = "abc"
            val needle = "c"

            val result = strStr(haystack, needle)
            println(result)
        }
        fun strStr(haystack: String, needle: String): Int {
            if (haystack.equals(needle)) return 0
            for (index in 0 until (haystack.length - needle.length + 1)) {
                val sub = haystack.substring(index,index + needle.length)
                if (sub.equals(needle)) return index
            }
            return -1
        }
    }
}