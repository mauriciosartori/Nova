package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No30 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun longestConsecutive(nums: IntArray): Int {
            var seqLength = 0
            val memo = HashSet<Int>()
            for (num in nums) {
                var count = 0
                var next = num + 1

                while (memo.contains(next)) {
                    count++
                    next = next + 1
                }
                seqLength = maxOf(seqLength, count)
                memo.add(num)
            }
            return seqLength
        }
    }
}