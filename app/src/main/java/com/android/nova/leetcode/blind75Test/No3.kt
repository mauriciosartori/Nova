package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }

        fun containsDuplicate(nums: IntArray): Boolean {
            val mapNumbers = HashSet<Int>()
            for(num in nums) {
                if (!mapNumbers.add(num)) {
                    return true
                }
            }
            return false
        }
    }
}