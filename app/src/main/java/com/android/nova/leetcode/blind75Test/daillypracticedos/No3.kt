package com.android.nova.leetcode.blind75Test.daillypracticedos
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun isPalindrome(x: Int): Boolean {
            val input = x.toString()
            var left = 0
            var right = input.length - 1

            while (left <= right) {
                if (input[left] != input[right]) {
                    return false
                }
                left++
                right--
            }
            return true
        }
    }
}