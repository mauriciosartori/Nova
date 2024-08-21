package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No14 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
            //val result = maxArea(intArrayOf(1,1))
            val result = maxArea(intArrayOf(4,3,2,1,4))

            println("Do something $result")
        }

        fun maxArea(height: IntArray): Int {
            var left = 0
            var right = height.size - 1
            var result = 0

            while (left < right) {
                val area = (right - left) * minOf(height[left], height[right])
                result = maxOf(result, area)

                if (height[left] < height[right]) {
                    left++
                } else if (height[left] > height[right]) {
                    right--
                } else {
                    right--
                }
            }
            return result
        }
    }
}