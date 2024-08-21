package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No13 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
            println("Do something")
        }

        fun maxArea(height: IntArray): Int {
            val hSorted = height.sortedArray()
            var start = hSorted[hSorted.size - 1]
            var end = hSorted[hSorted.size - 1]
            for (i in hSorted.size - 1 downTo 0) {
                if (hSorted[i] < end) {
                    end = hSorted[i]
                    break
                }
            }
            var startIndex = -1
            var endIndex = -1
            for (i in height.indices) {
                if (height[i] == start && startIndex == -1) {
                    startIndex = i
                }
                if (height[i] == end && endIndex == -1) {
                    endIndex = i
                }
            }
            val maxHeight = minOf(start, end)
            return (startIndex - endIndex) * maxHeight
        }
    }
}