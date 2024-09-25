package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No42 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun maxArea(height: IntArray): Int {
            val input = height
            var left = 0
            var right = input.size - 1
            var maxArea = 0

            while (left < right) {
                val length = right - left
                val maxHeight = minOf(input[right], input[left])
                var area = length * maxHeight
                maxArea = maxOf(maxArea, area)

                if (input[left] < input[right]) {
                    left++
                } else {
                    right--
                }
            }
            return maxArea
        }
    }
}