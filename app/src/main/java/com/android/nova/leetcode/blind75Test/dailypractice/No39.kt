package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No39 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val haystack = "sadbutsad"
            val needle = "sad"

            val result = strStr(haystack, needle)
            println(result)
        }
        fun strStr(haystack: String, needle: String): Int {
            val parent = haystack
            val child = needle

            var letterToFind = child[0]
            for ((index, currentChat) in parent.withIndex()) {
                if (currentChat == letterToFind) {
                    var nextIndex = index + 1
                    var childIndex = 1
                    while (childIndex < child.length) {
                        if (parent[nextIndex] != child[childIndex]) {
                            break
                        }
                        nextIndex++
                        childIndex++
                    }
                    if (childIndex >= child.length) return 0
                }
            }
            return -1
        }
    }
}